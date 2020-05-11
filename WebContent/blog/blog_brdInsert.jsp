<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.16/dist/summernote.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.16/dist/summernote.min.js"></script>
<script src="../js/summernote-ko-KR.js"></script>
<div id="c_brd_insert">
	<div class="container">
	    <div class="row">
	  		<div class="col-md-2"></div>
	        <div class="col-md-8">
	        	<select id="c_brdCategory" name="c_brdCategory">
	        		<option value="none">카테고리 없음</option>
	        		<option value="1">카테고리1</option>
	        		<option value="2">카테고리2</option>
	        		<option value="3">카테고리3</option>
	        	</select>
	        	<br/>
	       		<textarea id="c_brdSubject" placeholder="제목을 입력하세요"></textarea>
	       		<br/>
	        	<textarea id="c_summernote"></textarea>
	        	<button type="button" id="c_btnBrdInsert">글 등록</button>
	        </div>
	        <div class="col-md-2"></div>
	    </div>
	</div>
</div>

<script>blog.note()</script>