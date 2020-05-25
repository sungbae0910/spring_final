<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div id="c_brdWrite">
	<div class="container">
	    <div class="row">
	  		<div class="col-xs-1 col-md-2"></div>
	        <div class="col-xs-10 col-md-8">
	        	<select id="c_brdCategory" name="c_brdCategory">
	        		<option>카테고리 없음</option>
	        		<c:forEach var="i" items="${category}">
	        			<option>${i.cName}</option>
	        		</c:forEach>
	        	</select>
		        <div id="c_myblog_headerImg">
					<img id="c_bHeaderImg" src="./blog_image/${board.brdHeader}">
					<input type="file" id="c_btn_bHeaderImg">
					<button type="button" id="c_myblog_headerImg_add" class="btn btn-default btn-lg">
						<span class="glyphicon glyphicon-plus" aria-hidden="true"></span>
					</button>
					<button type="button" id="c_myblog_headerImg_rem" class="btn btn-default btn">
						<span class="glyphicon glyphicon-minus" aria-hidden="true"></span>
					</button>
				</div>
	       		<textarea id="c_brdSubject" placeholder="제목을 입력하세요">${board.subject}</textarea>
	       		<br/>
	        	<textarea id="c_summernote">${board.content}</textarea>
	        	<div id="c_tagList">
	        		<span class="c_tag">
		        		<span></span>
		        		<input type="text" id="c_tag" placeholder="#태그입력"/>
	        		</span>
	        	</div>
	        	<button type="button" id="c_btnBrdInsert">글 등록</button>
	        </div>
	        <div class="col-xs-1 col-md-2"></div>
	    </div>
	</div>
</div>

<script>blog.note()</script>