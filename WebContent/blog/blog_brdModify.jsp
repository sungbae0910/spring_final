<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div id="c_brdWrite">
	<div class="container">
	    <div class="row">
	  		<div class="col-xs-1 col-md-2"></div>
	        <div class="col-xs-10 col-md-8">
		        <form id="c_blog_frm" name="c_blog_frm" method="post" enctype="multipart/form-data">
		        	<input type="hidden" id="c_tagContent" name="c_tagContent"/> 
		        	<input type="hidden" name="c_bNo" value="${board.bNo}"/>
		        	<input type="hidden" name="c_brdNo" value="${board.brdNo}"/>
		        	<input type="hidden" id="c_basicSetVal" name="c_basicSet" value="${board.basicSet}"/>
		        	<select id="c_brdCategory" name="c_cName">
		        		<option>카테고리 없음</option>
		        		<c:forEach var="i" items="${category}">
		        			<option>${i.cName}</option>
		        		</c:forEach>
		        	</select>
		       		<textarea id="c_brdSubject" placeholder="제목을 입력하세요" name="c_subject">${board.subject}</textarea>
		       		<br/>
		        	<textarea id="c_summernote" name="c_content">${board.content}</textarea>
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
										<img id="c_bHeaderImg" src="./blog_image/${board.brdHeader}">
										<input type="file" id="c_btn_bHeaderImg" name="c_brdHeaderImg">
										<button type="button" id="c_myblog_headerImg_add" class="btn btn-default btn-lg">
											<span class="glyphicon glyphicon-plus" aria-hidden="true"></span>
										</button>
										<button type="button" id="c_myblog_headerImg_rem" class="btn btn-default btn">
											<span class="glyphicon glyphicon-minus" aria-hidden="true"></span>
										</button>
									</div>
									<div id="c_basicSet">
								    	<span id="c_setTitle">게시물 공개여부 </span>
								    	<span id="c_setPublic"><input type="radio" name="c_basicSet" id="c_brdPublic" value="0">공개</span>
								    	<span><input type="radio" name="c_basicSet" id="c_brdPrivate" value="1">비공개</span>
									</div>
							    </div>
							    <div class="modal-footer">
							        <button type="button" id="c_btnBrdModify_Close" class="btn btn-default" data-dismiss="modal">취소</button>
							        <button type="button" id="c_btnBrdModify_Con" class="btn btn-default">확인</button>
						    	</div>
							</div>
						</div>
					</div>
				</form>
	        	<button type="button" class="c_btnBrd" data-toggle="modal" data-target="#modifyModal">글 등록</button>
	        </div>
	        <div class="col-xs-1 col-md-2"></div>
	    </div>
	</div>
</div>

<script>
	blog.brdModi(); 
	blog.myblog_func();
	
	//게시물 공개여부데이터 라디오버튼체크 
	if ($("#c_basicSetVal").val() == 0) {
		$("#c_brdPublic").prop("checked", true);
	} else {
		$("#c_brdPrivate").prop("checked", true);
	}
</script>