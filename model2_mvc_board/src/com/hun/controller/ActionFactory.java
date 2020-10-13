package com.hun.controller;

import com.hun.controller.action.Action;
import com.hun.controller.action.BoardCheckPassAction;
import com.hun.controller.action.BoardCheckPassFormAction;
import com.hun.controller.action.BoardDeleteAction;
import com.hun.controller.action.BoardListAction;
import com.hun.controller.action.BoardUpdateAction;
import com.hun.controller.action.BoardUpdateFormAction;
import com.hun.controller.action.BoardViewAction;
import com.hun.controller.action.BoardWriteAction;
import com.hun.controller.action.BoardWriteFormAction;

public class ActionFactory {
	private static ActionFactory instance = new ActionFactory();

	private ActionFactory() {
		// TODO Auto-generated constructor stub
		super();
	}

	public static ActionFactory getInstance() {
		// TODO Auto-generated method stub
		return instance;
	}

	public Action getAction(String command) { // board_list
		// TODO Auto-generated method stub
		Action action = null;
		System.out.println("ActionFactory : " + command);
		/* 추가된 부분 */
		if (command.equals("board_list")) {
			action = new BoardListAction();
		} else if (command.equals("board_view")) {
			action = new BoardViewAction();
			System.out.println(action);
		} else if (command.equals("board_check_pass_form")) {
			action = new BoardCheckPassFormAction();
		} else if (command.equals("board_check_pass")) {
			action = new BoardCheckPassAction();
		} else if (command.equals("board_update_form")) {
			action = new BoardUpdateFormAction();
		} else if (command.equals("board_update")) {
			action = new BoardUpdateAction();
		} else if (command.equals("board_delete")) {
			action = new BoardDeleteAction();
		} else if (command.equals("board_write_form")) {
			action = new BoardWriteFormAction();
		} else if (command.equals("board_write")) {
			action = new BoardWriteAction();
			System.out.println(action);
		}
		return action;
	}
}