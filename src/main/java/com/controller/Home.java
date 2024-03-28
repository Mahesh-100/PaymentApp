package com.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;
import com.controller.dao.UserDao;
import com.controller.entity.BankDTO;
import com.controller.entity.StatementDTO;
import com.controller.entity.UserDTO;





@Controller
public class Home {
	
	UserDao userDAO= new UserDao();
	ModelAndView mv= new ModelAndView();
	@GetMapping("/registration")
	public ModelAndView  getRegistrationPage() {
		
		mv.setViewName("registration");
		return mv;
	}
	@PostMapping("/registration")
	public ModelAndView getUserDetails(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String username = request.getParameter("username");
        String password = request.getParameter("password");
        String userFullname = request.getParameter("fullname");
        String phoneNo = request.getParameter("phone_no");
        String email = request.getParameter("email");
        String userAddress = request.getParameter("address");

    UserDTO user= new UserDTO(username,password,userFullname,phoneNo,email,userAddress);
    
       if(userDAO.saveUserDetails(user)) {
  
    	   mv.setViewName("login");
		}else {
			mv.setViewName("registration");
			}
	return mv;
}
	
	  @GetMapping("/login")
	    public String showLoginForm() {
	        return "login";
	    }

	    @PostMapping("/login")
	    public ModelAndView processLogin(@RequestParam("username") String username,
	                               @RequestParam("password") String password,
	                               HttpSession session,
	                               Model model) {
	    	ModelAndView mv = new ModelAndView();
	        UserDTO user = userDAO.showUserDetails(username, password);
	        if (user != null) {
	        	
	        	List<BankDTO> bank=userDAO.getBankDetailsByUserId(user.getUser_id());
	        	session.setAttribute("user", user);
	        	model.addAttribute("banklist", bank);
	           mv.setViewName("home");
	        } else {
	            mv.setViewName("login"); 
	        }
			return mv;
	    }
	    
	   
	   
	    
//	    @GetMapping("/addaccount")
//	    public ModelAndView showBankDetailsForm() {
//	        ModelAndView modelAndView = new ModelAndView("AddAccount");
//	        modelAndView.addObject("bank", new BankDTO());
//	        return modelAndView;
//	    }
//	    
//	    @PostMapping("/addaccount")
//	    public ModelAndView addBankDetails(@ModelAttribute("bank") BankDTO bank) {
//	        ModelAndView mv = new ModelAndView();
//	        try {
//	            // Convert BankDetailsForm to BankDetails entity and save
//	        	BankDTO bankDetails = convertToBankDTOEntity(bank);
//	        	if(userDAO.saveBankDetails(bankDetails)) {
//	        		mv.setViewName("redirect:/home");
//	        		
//	        	}
//	            
//	        } catch (Exception e) {
//	            mv.setViewName("redirect:/login");
//	            mv.addObject("error", "Failed to insert bank details. Please try again.");
//	        }
//	        return mv;
//	    }
//
//	    private BankDTO convertToBankDTOEntity(BankDTO bankDetails) {
//	    	BankDTO bank_info = new BankDTO();
//	        bank_info.setUser_id(bankDetails.getUser_id());
//	        bank_info.setBank_account_no(bankDetails.getBank_account_no());
//	        bank_info.setBank_name(bankDetails.getBank_name());
//	        bank_info.setIFSC_code(bankDetails.getIFSC_code());
//	        bank_info.setAccount_type(bankDetails.getAccount_type());
//	        bank_info.setCurrent_balance(bankDetails.getCurrent_balance());
//	        return bank_info;
//	    }
	    
	    @GetMapping("/addaccount")
		public ModelAndView  getAddBankPage() {
			
			mv.setViewName("AddAccount");
			return mv;
		}  
	  
	   
	    
	    @PostMapping("/addaccount")
	    public ModelAndView processAddAccount(HttpServletRequest request, HttpServletResponse response, Model model) {
	    	
	    	String user_id_string=request.getParameter("user_id");
	    	int user_id=Integer.parseInt(user_id_string);
	    	String bank_account=request.getParameter("accountNumber");
	    	String bank_name=request.getParameter("bankName");
	    	String IFSC_Code=request.getParameter("ifscCode");
	    	String account_type=request.getParameter("accountType");
	    	String money=request.getParameter("initialBalance");
	    	double current_balance=Double.parseDouble(money);
	    	
	    	
	    	BankDTO bank_info=new BankDTO(user_id,bank_account,bank_name,IFSC_Code,account_type,current_balance);
	    	if(userDAO.saveBankDetails(bank_info)) {
	    		HttpSession session=request.getSession();
	    		UserDTO user=(UserDTO)session.getAttribute("user");
	    		List<BankDTO> bank=userDAO.getBankDetailsByUserId(user.getUser_id());
	    		model.addAttribute("banklist", bank);
	    		mv.setViewName("home");
	    		
	    	}else {
	    		model.addAttribute("error", "something went wrong");
	    		mv.setViewName("AddAccount");
	    	}
			return mv;
	    	
	    }
	    
	    
	    @PostMapping("/navigate")
	    public ModelAndView processButton(@RequestParam("selectedAction") String selectedAction,
	                               @RequestParam("selectedAccount") int accountID) {
	        ModelAndView modelAndView = new ModelAndView();
	        
	        modelAndView.addObject("accountID", accountID);
	        
	       
	        if ("Statement".equals(selectedAction)) {
	            modelAndView.setViewName("Statement"); 
	        } else if ("AddMoney".equals(selectedAction)) {
	            modelAndView.setViewName("AddMoney"); 
	        } else if ("SendMoney".equals(selectedAction)) {
	            modelAndView.setViewName("SendMoney"); 
	        } else {
	            modelAndView.setViewName("login"); 
	        }
	        
	        return modelAndView;
	    }
	    
	    
	    @PostMapping("/addmoney")
	    public ModelAndView addMoney(@RequestParam("accountID") int accountID,
	                                   @RequestParam("amount") double amount) {
	    	
	    	Date currentDate = new Date(System.currentTimeMillis());
	    	
	    	StatementDTO transaction=new StatementDTO(accountID,accountID,amount,"add", currentDate);
	    	
	    	mv.addObject("accountID", accountID);
	    	double currentBalance=userDAO.getCurrentBalance(accountID);
	    	double newBalance=currentBalance+amount;
	    	
	    	
	    	boolean updateBalance=userDAO.updateBalance(accountID, newBalance);
	    	boolean TransactionSuccess=userDAO.logTransaction(transaction);
	    	if(updateBalance && TransactionSuccess) {
	    		mv.addObject("success", "succesfully added money");
	    		mv.setViewName("login");
	    		
	    	}else {
	    		mv.addObject("error", "unable to add money");
	    		mv.setViewName("info");
	    	}
	    	return mv;
	    	
	    	
	    }
	    
	    @GetMapping("/logout")
		public ModelAndView  logout(HttpServletRequest request, HttpServletResponse response, SessionStatus status) {
	    	status.setComplete(); 
	        request.getSession().invalidate();
	    	mv.setViewName("login");
			return mv;
		}     
	    @PostMapping("/sendmoney")
	    public ModelAndView sendMoney(@RequestParam("accountID") int sourceAccountID,
	                                   @RequestParam("amount") double amount,
	                                   @RequestParam("recipientAccount") String toAccountNumber) throws SQLException {
	    	
	    	
	    	int targetAccountID = userDAO.getAccountIdByAccountNumber(toAccountNumber);
	    	
	    	double sourceBalance=userDAO.getCurrentBalance(sourceAccountID);
	    	double newSourceBalance=sourceBalance-amount;
	    	boolean updateSourceBalance=userDAO.updateBalance(sourceAccountID, newSourceBalance);
	    	Date currentDate = new Date(System.currentTimeMillis());
	    	
			StatementDTO transactionOfSource=new StatementDTO(sourceAccountID,targetAccountID,amount,"debit", currentDate);
			StatementDTO transactionOfTarget=new StatementDTO(targetAccountID,sourceAccountID,amount,"credit", currentDate);
	    	
	    	double targetBalance=userDAO.getCurrentBalance(targetAccountID);
	    	double newTargetBalance=targetBalance + amount;
	    	 boolean updateTargetBalance=userDAO.updateBalance(targetAccountID, newTargetBalance);
	    	 
	    	 boolean sourceTransaction=userDAO.logTransaction(transactionOfSource);
	    	 boolean targetTransaction=userDAO.logTransaction(transactionOfTarget);
	    	 
	    	 if (updateSourceBalance && updateTargetBalance && sourceTransaction && targetTransaction) {
				mv.addObject("success", "succesfully sent money");	
	    		 mv.setViewName("login");
		        } else {
		        	mv.addObject("error","unable to send money");
		        	mv.setViewName("info");
		        }
			return mv;
	    			

			}
	    
	    
	    @PostMapping("/transaction")
	    public ModelAndView processTransactions(@RequestParam("accountID") int accountID,
	                                   @RequestParam("startDate") String startDatestr,
	                                   @RequestParam("endDate") String endDatestr) {
	    	
	    	ModelAndView mv= new ModelAndView();
	    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	        Date startDate = null;
	        Date endDate = null;
	    	 
	    	
	    	try {
	    		startDate = sdf.parse(startDatestr);
	            endDate = sdf.parse(endDatestr);
	    	List<StatementDTO> transactions=userDAO.getAllTransactions(accountID, startDate, endDate);
			 mv.addObject("transactions", transactions);
			 mv.setViewName("displayStatement");
		
	    	}catch(Exception e) {
	    		e.printStackTrace();
	    	}
			
			return mv;
           
			
			
	    }
	   
}


