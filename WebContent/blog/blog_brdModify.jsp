<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div id="c_brdWrite">
	<div class="container">
	    <div class="row">
	  		<div class="col-xs-1 col-md-2"></div>
	        <div class="col-xs-10 col-md-8">
	        	<select id="c_brdCategory" name="c_brdCategory">
	        		<option value="none">카테고리 없음</option>
	        		<option value="1">카테고리1</option>
	        		<option value="2">카테고리2</option>
	        		<option value="3">카테고리3</option>
	        	</select>
		        <div id="c_myblog_headerImg">
					<img id="c_bHeaderImg">
					<input type="file" id="c_btn_bHeaderImg">
					<button type="button" id="c_myblog_headerImg_add" class="btn btn-default btn-lg">
						<span class="glyphicon glyphicon-plus" aria-hidden="true"></span>
					</button>
					<button type="button" id="c_myblog_headerImg_rem" class="btn btn-default btn">
						<span class="glyphicon glyphicon-minus" aria-hidden="true"></span>
					</button>
				</div>
	       		<textarea id="c_brdSubject" placeholder="제목을 입력하세요"></textarea>
	       		<br/>
	        	<textarea id="c_summernote"></textarea>
	        	<button type="button" id="c_btnBrdInsert">글 등록</button>
	        </div>
	        <div class="col-xs-1 col-md-2"></div>
	    </div>
	</div>
</div>

<script>blog.note()</script>