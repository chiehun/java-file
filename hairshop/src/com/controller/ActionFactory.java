package com.controller;

import com.controller.action.Action;
import com.controller.action.CusIndexAction;
import com.controller.action.CusJoinAction;
import com.controller.action.CusJoinFormAction;
import com.controller.action.CusLoginAction;
import com.controller.action.CusLoginFormAction;
import com.controller.action.CusLogoutAction;
import com.controller.action.CusResDeleteAction;
import com.controller.action.CusResEndAction;
import com.controller.action.CusResUpdateAction;
import com.controller.action.CusReservationCheckAction;
import com.controller.action.CusReservationDeleteAction;
import com.controller.action.CusReservationFormAction;
import com.controller.action.CusReservationInsertAction;
import com.controller.action.CustomerDeleteAction;
import com.controller.action.CustomerDetailAction;
import com.controller.action.CustomerInsertAction;
import com.controller.action.CustomerListAction;
import com.controller.action.CustomerUpdateAction;
import com.controller.action.IdCheckFormAction;
import com.controller.action.IndexAction;
import com.controller.action.LoginAction;
import com.controller.action.ReservationListAction;
import com.controller.action.ReservationOnListAction;

public class ActionFactory {
	private static ActionFactory instance = new ActionFactory();


	public ActionFactory() {
		super();
		// TODO Auto-generated constructor stub
	}

	public static ActionFactory getInstance() {
		// TODO Auto-generated method stub
		return instance;
	}

	public Action getaction(String command) {
		Action action = null;
		System.out.println("Actionfactory"+" : " + command);// 확인 코드
		if (command.equals("res_list")) {
			action = new ReservationListAction();
		} else if (command.equals("Admin_login")) {
			action = new LoginAction();			
		} else if (command.equals("reson_list")) {
			action = new ReservationOnListAction();
		} else if (command.equals("cusres_update")) {
			action = new CusResUpdateAction();
		} else if (command.equals("cusres_delete")) {
			action = new CusResDeleteAction ();
		} else if (command.equals("cusres_end")) {
			action = new CusResEndAction();
		} else if (command.equals("cus_insert")) {
			action = new CustomerInsertAction();
		} else if (command.equals("cus_list")) {
			action = new CustomerListAction ();
		} else if (command.equals("cus_delete")) {
			action = new CustomerDeleteAction();
		} else if (command.equals("cus_update")) {
			action = new CustomerUpdateAction ();
		} else if (command.equals("cus_detail")) {
			action = new CustomerDetailAction();
		} else if (command.equals("id_check_form")) {
			action = new IdCheckFormAction();
		}else if (command.equals("index")) {
			action = new IndexAction();
		}	
		
	// 고객(customer)
		else if (command.equals("cus_index")) {
		action = new CusIndexAction();
	} else if (command.equals("cus_login_form")) {
		action = new CusLoginFormAction();
	} else if (command.equals("cus_login")) {
		action = new CusLoginAction();
	} else if (command.equals("cus_join")) {
		action = new CusJoinAction();
	} else if (command.equals("cus_join_form")) {
		action = new CusJoinFormAction();
	} else if (command.equals("cus_res_check")) {
		action = new CusReservationCheckAction();
	} else if (command.equals("cus_res_form")) {
		action = new CusReservationFormAction();
	} else if (command.equals("cus_index")) {
		action = new CusIndexAction();
	} else if (command.equals("cus_logout")) {
		action = new CusLogoutAction();
	} else if (command.equals("cus_res_insert")) {
		action = new CusReservationInsertAction();
	} else if (command.equals("cus_res_delete")) {
		action = new CusReservationDeleteAction();
	}   
		return action;
	}
}