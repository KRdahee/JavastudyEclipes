<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    // 클라이언트로부터 전송된 게시물 정보 파라미터 받기
    String postId = request.getParameter("postId");
    String updatedTitle = request.getParameter("title");
    String updatedContent = request.getParameter("content");

    // 여기서는 단순히 예시로 게시물 ID를 확인하고 수정된 제목과 내용을 출력합니다.
    out.println("업데이트된 게시물 ID: " + postId);
    out.println("<br>");
    out.println("업데이트된 제목: " + updatedTitle);
    out.println("<br>");
    out.println("업데이트된 내용: " + updatedContent);
%>
