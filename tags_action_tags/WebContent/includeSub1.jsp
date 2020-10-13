<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

	<b><% String name = request.getParameter("name"); %></b>
	
	포함되는 페이지 includeSub 입니다.
	<b><%= name %> 님 어서오세요]</b>