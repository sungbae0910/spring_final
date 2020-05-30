<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div id="c_brdWrite">
	<div class="container">
	    <div class="row">
	        <div class="col-md-12">
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
	        	<div id="c_tagBox">
						<div id="c_tagList"></div>
						<span class="c_inpTag">
							<span>#</span>
								<input type="text" class="c_tag" id="c_tag" placeholder="태그입력"/>
						</span>
					</div>
					<!-- 모달 -->
			        <div id="modifyModal" class="modal fade" role="dialog">
						<div class="modal-dialog">
						    <div class="modal-content">
						    	<div class="modal-header">
							        <button type="button" class="close" data-dismiss="modal">&times;</button>
							        <h4 class="modal-title">발행</h4>
								</div>
							    <div class="modal-body">
							    	<div id="c_myblog_headerImg">
										<img id="c_bHeaderImg">
										<input type="file" id="c_btn_bHeaderImg" name="c_brdHeaderImg">
										<button type="button" id="c_myblog_headerImg_add" class="btn btn-default btn-lg">
											<span class="glyphicon glyphicon-plus" aria-hidden="true"></span>
										</button>
										<button type="button" id="c_myblog_headerImg_rem" class="btn btn-default btn">
											<span class="glyphicon glyphicon-minus" aria-hidden="true"></span>
										</button>
									</div>
									<div id="c_basicSet">
								    	<span id="c_setTitle">기본</span>
								    	<span id="c_setPublic"><input type="radio" name="c_basicSet" value="0" checked="checked">공개</span>
								    	<span><input type="radio" name="c_basicSet" value="1">비공개</span>
									</div>
							    </div>
							    <div class="modal-footer">
							        <button type="button" id="c_btnBrdModify_Close" class="btn btn-default" data-dismiss="modal">취소</button>
							        <button type="button" id="c_btnBrdModify_Con" class="btn btn-default">확인</button>
						    	</div>
							</div>
						</div>
					</div>
	        	<button type="button" id="c_btnBrdInsert">글 등록</button>
	        </div>
	    </div>
	</div>
</div>

<script>blog.note()</script>