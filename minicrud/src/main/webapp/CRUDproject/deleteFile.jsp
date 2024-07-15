<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.io.File" %>
<%@ page import="java.io.IOException" %>
<%@ page import="javax.servlet.http.HttpServletResponse" %>

<%
    // 클라이언트로부터 전송된 파일 이름 파라미터 받기
    String fileName = request.getParameter("fileName");

    // 파일이 저장된 경로 설정
    String uploadPath = "/your/upload/directory/path"; // 실제 파일 업로드 경로로 수정 필요

    // 실제 파일 경로 설정
    String filePath = uploadPath + File.separator + fileName;

    // 파일 삭제 처리
    File fileToDelete = new File(filePath);
    boolean deleteResult = false;

    if (fileToDelete.exists()) {
        deleteResult = fileToDelete.delete();
    }

    // Ajax 요청에 대한 응답
    if (deleteResult) {
        response.setStatus(HttpServletResponse.SC_OK); // 성공적으로 삭제됨
    } else {
        response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "파일 삭제 실패"); // 삭제 실패 시 에러 응답
    }
%>
