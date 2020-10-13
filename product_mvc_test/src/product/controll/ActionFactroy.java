package product.controll;

import product.controllaction.Action;
import product.controllaction.productCheckPassAction;
import product.controllaction.productCheckPassFormAction;
import product.controllaction.productDeleteAction;
import product.controllaction.productListAction;
import product.controllaction.productMultiUploadAction;
import product.controllaction.productMultiUploadFormAction;
import product.controllaction.productUpdateAction;
import product.controllaction.productUpdateFormAction;
import product.controllaction.productViewAction;
import product.controllaction.productWriteAction;
import product.controllaction.productWriteFormAction;

public class ActionFactroy {
	public static ActionFactroy instance = new ActionFactroy();
	public ActionFactroy() {
		
	}

	public static ActionFactroy getInstance() {
		// TODO Auto-generated method stub
		return instance;
	}

	public Action getAction(String command) {
		// TODO Auto-generated method stub
		Action action = null;
		System.out.println("ActionFactroy : "+command);  // ActionFactroy 에 command 값이 잘 들어왔느지 확인하는 코드
		
		if(command.equals("product_list")) {
			action = new productListAction();
		} else if(command.equals("product_write_form")) {
			action = new productWriteFormAction();
			
		} else if(command.equals("product_write")) {
			action = new productWriteAction();
			
		} else if(command.equals("product_update_form")) {
			action = new productUpdateFormAction();
			
		} else if(command.equals("product_update")) {
			action = new productUpdateAction();
			
		} else if(command.equals("product_delete")) {
			action = new productDeleteAction();
			
		} else if(command.equals("product_check_pass")) {
			action = new productCheckPassAction();
			
		} else if(command.equals("product_check_pass_form")) {
			action = new productCheckPassFormAction();
			
		} else if(command.equals("product_MultiUpload")) {
			action = new productMultiUploadAction();
			
		} else if(command.equals("product_MultiUpload_form")) {
			action = new productMultiUploadFormAction();
			
		} else if(command.equals("product_View")) {
			action = new productViewAction();
			
		}							
		return action;
	}

}
