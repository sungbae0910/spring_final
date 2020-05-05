<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<!-- css -->
<link href="../css/all.min.css" rel="stylesheet">
<link href="../css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="../css/news.css">
<!-- js -->
<script src="../js/jquery-3.4.1.js"></script>
</head>
<body>
<div id="news_s">
	<div class="container" style="border:1px solid black;">
		<div class="row justify-content-md-center">
			<div class="col" id="hlog">
				<div class="logo_s">
					�����Դϴ�
				</div>
				<a href="#">�����Դϴ�</a>
				<a href="#">�����Դϴ�</a>
				<a href="#">�����Դϴ�</a>
			</div>
		<!-- row -->
		</div>
	<!-- container -->
	</div>
	
	<div class="container" style="border:1px solid black;">
		<div class="row">
			<div class="col-sm">
				<div class="head_s">
					<a href="#"><h2>����</h2></a>
					<a href="#"><h2>����</h2></a>
					<a href="#"><h2>������</h2></a>
				</div>
				<form class="form-inline" id="nMainSearch_s">
					<input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
					<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
				</form>
			</div>
		<!-- row -->
		</div>
	<!-- container -->
	</div>
	
	<div class="container" style="border:1px solid black;">
		<div class="row">
			<div class="col-sm">
				<nav class="navbar navbar-expand navbar-light">
					<div class="collapse navbar-collapse" id="navbarNav">
						<ul class="navbar-nav">
							<li class="nav-item active">
								<a class="nav-link" href="#">Ȩ</a>
							</li>
							<li class="nav-item">
								<a class="nav-link" href="#">��ȸ</a>
							</li>
							<li class="nav-item">
								<a class="nav-link" href="#">��ġ</a>
							</li>
							<li class="nav-item">
								<a class="nav-link" href="#">����</a>
							</li>
							<li class="nav-item">
								<a class="nav-link" href="#">����</a>
							</li>
							<li class="nav-item">
								<a class="nav-link" href="#">��ȭ</a>
							</li>
							<li class="nav-item">
								<a class="nav-link" href="#">IT</a>
							</li>									
						</ul>
					</div>
				</nav>
			</div>
		<!-- row -->
		</div>
	<!-- container -->
	</div>	

	<div class="container" style="border:1px solid black;">
		<div class="row">
			<div class="col-sm">
				<div id="cSub" class="hcg_media_pc_cSub">
					<div class="head_view">
						<div class="info_cp">�ƽþư���</div>
						<h3 class="tit_view">�ڼ���, ������ ���⸶ '���̾߱�' ����...</h3>	
						<span class="info_view">
							<span class="txt_info">������</span>
							<span class="txt_info">�Է� 2020.05.05. 12:33</span>
							<button id="alexCounter" class="emph_g2 link_cmt">
								���<span class="alex-count-area">5</span>��						
							</button>
						</span>				
					</div>
				</div>				
			</div>
		<!-- row -->
		</div>
	<!-- container -->
	</div>
	
	<div class="container" style="border:1px solid black;">
		<div class="row">
			<div class="col-sm-8">
				<div class="news_view">
					<figure class="figure">
						<img src="../image/landscape.jpg" class="figure-img img-fluid rounded" alt="...">
						<figcaption class="figure-caption">A caption for the above image.</figcaption>
					</figure>
					<p>
						(����=���մ���) ���ֶ� ���� = ���δ� ������ ����溸 �ܰ踦 ������ '�ɰ�'���� '���'�� ���ߴ��� ����ũ 5���� �� ���� 
						�ڷγ����̷��� ������(�ڷγ�19) ���� ���� ��å���� ū ��ȭ�� ���� ���̶�� ������.
					</p>	
				</div>
			</div>
			<div class="col-sm-4">
				<div class="hc_news_pc_mAside_popular_news">
					<div class="aside_g aside_popular">
						<div class="top_new_s">
							<h3 class="txt_newsview">���� �� ����</h3>
							<a href="#" class="link_tab link_tab2">����</a>
							<a href="#" class="link_tab link_tab3">����</a>
							<a href="#" class="link_tab link_tab4">������</a>
						</div>
						<p/>
						<ul class="tab_aside tab_media">
							<li class="on">
								<div class="cont_aside">
									<ol class="list_ranking">
										<c:forEach begin="1" end="10" var="i" varStatus="ii">
											<li>
												<em class="num_newsview num${ii.index}">1</em>
												<strong class="tit_g">
													<a href="#" class="link_txt @${ii.index}">��¼����¼�̱�������asdasdasasdasdads</a>
												</strong>
											</li>
										</c:forEach>																				
									</ol>
								</div>
							</li>													
						</ul>
					</div>
				</div>
			</div>
		<!-- row -->
		</div>
	<!-- container -->
	</div>


	<div class="container" style="border:1px solid black;">
		<div class="row">
			<div class="col-sm-8">
				<div class="count_comment_s">��� 48��</div>
				<div class="input-group mb-3">
					<input type="text" class="form-control" placeholder="����� �Է����ּ���" aria-label="Recipient's username" aria-describedby="button-addon2">
					<div class="input-group-append">
					 	<button class="btn btn-outline-secondary" type="button" id="button-addon2">�Է�</button>
					</div>
				</div>
				<div class="cmt_box">
					<ul class="list_category">
						<li>��õ��</li>
						<li>��ϼ�</li>
					</ul>
				</div>
				<div class="com_to_s">
					<div class="com_body_s">
						<span class="txt_id">������</span>
						<span class="txt_date">2020.05.05. 12:33</span>
						<p class="com_cont_s">asdasdas</p> 
					</div>
					<div class="box_reply">
						<span class="box_inner">
							<button class="reply_count">
								<span>
									<span>���</span>
									<span class="num_txt">3</span>
								</span>
							</button>
						</span>
						<span class="comment_recomm">
							<button class="btn_g btn_recomm"  style="border: none;">
								<span class="img_cmt ico_recomm bounce">����</span>
								<span class="num_txt">200</span>
							</button>
							<button class="btn_g btn_oppose"  style="border: none;">
								<span class="img_cmt ico_oppose bounce">����õ</span>
								<span class="num_txt">5</span>
							</button>
						</span>
					</div>
				</div>
				<div class="com_to_s">
					<div class="com_body_s">
						<span class="txt_id">������</span>
						<span class="txt_date">2020.05.05. 12:33</span>
						<p class="com_cont_s">asdasdas</p> 
					</div>
					<div class="box_reply">
						<span class="box_inner">
							<button class="reply_count">
								<span>
									<span>���</span>
									<span class="num_txt">3</span>
								</span>
							</button>
						</span>
						<span class="comment_recomm">
							<button class="btn_g btn_recomm"  style="border: none;">
								<span class="img_cmt ico_recomm bounce">����</span>
								<span class="num_txt">200</span>
							</button>
							<button class="btn_g btn_oppose"  style="border: none;">
								<span class="img_cmt ico_oppose bounce">����õ</span>
								<span class="num_txt">5</span>
							</button>
						</span>
					</div>
				</div>				
			</div>
		<!-- row -->
		</div>
	<!-- container -->
	</div>



<!-- news_s -->
</div>






<script src="../js/bootstrap.bundle.min.js"></script>
</body>
</html>