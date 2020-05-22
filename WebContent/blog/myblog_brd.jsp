<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div id="c_dimmedSidebar"></div>
<form id="c_blog_frm" name="c_blog_frm" method="post">
	<input type="hidden" name="c_brdNo" value="${brdVo.brdNo}"/>
	<input type="hidden" name="c_mId" id="c_mId" value="${myblogHeader.mId}"/>
	<input type="hidden" name="c_cName" id="c_cName"/>
</form>
<aside id="c_sidebar">
	<div id="c_innerSidebar">
		<button type="button" class="btn btn-default btn-lg x" id="c_sidebar_close">
  			<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>
		</button>
		<button type="button"class="btn btn-default btn-lg home" onclick="blog.myblog()">
	  		<span class="glyphicon glyphicon-home" aria-hidden="true"></span> ${myblogHeader.bTitle}
		</button>
		<div id="c_myblog_Cate">
			<c:forEach var="c" items="${myblogHeader.category}">
				<div class="c_CateItem" onclick="blog.category('${c.cName}')">${c.cName} <span>(${c.cnt})</span></div>
			</c:forEach>
		</div>
		<hr/>
		<div id="c_myblog_manageTool">
			<button type="button" onclick="blog.brdInsert()">글쓰기</button>
			<button type="button" onclick="blog.manageMain()">블로그 관리</button>
		</div>
	</div>
</aside>
<div id="c_myBlog_header">
	<div class="container-fluid">
	    <div class="row">
	        <div class="col-xs-12">
	        	<img id="c_myBlog_headerImg" src="./blog_image/${brdVo.brdHeader}">
	        	<img id="c_sidebar_open" src="./blog_image/menu2.png">
	        	<div id="c_myblogTitle" onclick="blog.myblog()">${myblogHeader.bTitle}</div>
	        	<div id="c_brdItem">
		        	<div id="c_brd_Subject">${brdVo.subject}</div>
		        	<div id="c_brd_Date">${brdVo.brdDate}</div>
	        	</div>
	        </div>
	    </div>
	</div>
</div>
<div id="c_brd">
	<div class="container">
	    <div class="row">
	    	<div class="col-md-2"></div>
	        <div class="col-md-8">
		        <div id="c_brd_Cont">${brdVo.content}</div>
	        	<div id="c_brd_btn_group">
	        		<c:choose>
	        			<c:when test="${brdVo.brdLike == 0}">
  							<span id="c_btnBrdLike" class="glyphicon glyphicon-heart-empty" aria-hidden="true">공감</span>
	        			</c:when>
	        			<c:otherwise>
  							<span id="c_btnBrdLike" class="glyphicon glyphicon-heart-empty" aria-hidden="true">${brdVo.brdLike}</span>
	        			</c:otherwise>
	        		</c:choose>
  					<div class="dropdown" id="c_brd_manage">
      					<span class="dropdown-toggle" data-toggle="dropdown">
  							<span class="glyphicon glyphicon-option-horizontal" aria-hidden="true"></span>
      					</span>
	        			<ul class="dropdown-menu">
	        			  <li><a href="#" onclick="blog.brdModify()">수정</a></li>
			      		  <li><a href="#" id="c_btnBrdDelete">삭제</a></li>
			      		  <li><a href="#" id="c_btnBrdPublic"> 공개로 전환</a></li>
			      		  <li><a href="#" id="c_btnBrdSecret"> 비공개로 전환</a></li>
	        			</ul>
      				</div>
	        	</div>
		        <div id="c_cmt">
		        	<span id="c_cmt_title">댓글 10</span>
		        	<hr/>
			        <div class="c_cmt">
		        		<img src="./blog_image/cat.jpg" class="img-circle" alt="">
		        		<div class="dropdown" id="c_cmt_manage">
	      					<span class="dropdown-toggle" data-toggle="dropdown">
	  							<span class="glyphicon glyphicon-option-vertical" aria-hidden="true"></span>
	      					</span>
		        			<ul class="dropdown-menu">
		        			  <li id="c_btnCmtModify" class="c_modify" data-toggle="modal" data-target="#myModal"><span>수정</span></li>
				      		  <li id="c_btnCmtDelete" class="c_delete"><span>삭제</span></li>
		        			</ul>
      					</div>
		        		<div class="c_cmtMid">댓글 단 사람</div>
		        		<div class="c_cmtDate">2020.05.07 23:53</div>
		        		<div class="c_cmtBlame">신고</div>
		        		<div class="c_cmtContent">안녕하세요 나는 댓글이에요</div>
		        		<div id="c_btnRepl" class="c_btnRepl" data-toggle="modal" data-target="#myModal">답글</div>
		        	</div>
		        	<div class="c_repl">
		        		<img src="./blog_image/landscape.jpg" class="img-circle">
		        		<div class="dropdown" id="c_cmt_manage">
	      					<span class="dropdown-toggle" data-toggle="dropdown">
	  							<span class="glyphicon glyphicon-option-vertical" aria-hidden="true"></span>
	      					</span>
		        			<ul class="dropdown-menu">
		        			  <li id="c_btnReplModify" class="c_modify" data-toggle="modal" data-target="#myModal"><span>수정</span></li>
				      		  <li id="c_btnReplDelete" class="c_delete"><span>삭제</span></li>
		        			</ul>
      					</div>
		        		<div class="c_cmtMid">답글 단 사람</div>
		        		<div class="c_cmtDate">2020.05.07 23:53</div>
		        		<div class="c_cmtBlame">신고</div>
		        		<div class="c_cmtContent">안녕하세요 나는 답글!!안녕하세요 나는 답글!!안녕하세요 나는 답글!!안녕하세요 나는 답글!!안녕하세요 나는 답글!!안녕하세요 나는 답글!!안녕하세요 나는 답글!!안녕하세요 나는 답글!!</div>
		        	</div>
		        	<textarea placeholder="댓글을 입력해주세요."></textarea>
		        	<label><input type="checkbox" name="c_cmtSecret"/> 비밀글</label>
		        	<input type="button" id="c_cmtInsert" value="댓글 남기기"/>
		        </div>
		        <!-- 수정 & 답글 모달 -->
		        <div id="myModal" class="modal fade" role="dialog">
					<div class="modal-dialog">
					    <div class="modal-content">
					    	<div class="modal-header">
						        <button type="button" class="close" data-dismiss="modal">&times;</button>
						        <h4 class="modal-title">댓글 수정</h4>
							</div>
						    <div class="modal-body">
						    	<img id="c_modifyImg" src="./blog_image/landscape.jpg" class="img-circle">
						    	<span id="c_modifyMid">나야 아이디</span><br/>
						    	<textarea id="c_modifyContent"></textarea>
						    </div>
						    <div class="modal-footer">
						        <button type="button" id="c_btnCmtModify_Close" class="btn btn-default" data-dismiss="modal">취소</button>
						        <button type="button" id="c_btnCmtModify_Con" class="btn btn-default">확인</button>
					    	</div>
						</div>
					</div>
				</div>
	        </div>
	        <div class="col-md-2"></div>
	    </div>
	</div>
</div>
<script>blog.myblog_func();</script>