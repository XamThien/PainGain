<%@page import="model.Account"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="model.NhanVien"%>
<%@page import="DAO.NhanVienDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<aside class="main-sidebar">
    <!-- sidebar: style can be found in sidebar.less -->
    <section class="sidebar">
        <!-- Sidebar user panel -->
        <div class="user-panel">
            <div class="pull-left image">
                <img src="${pageContext.request.contextPath}/images/avatar5.png" class="img-circle"
                     alt="User Image">
            </div>
            <div class="pull-left info">
            	<%
	            	HttpSession sessi = request.getSession();
	                Account nvcx = (Account)sessi.getAttribute("login");
	                if (nvcx==null)
	                {
	                %> 
	                	<c:redirect url="/login.jsp" />
	                <%
	                }
	                
	                NhanVien nvv = new NhanVienDAO().getNhanVienByID(nvcx.getMaAc());
	                
            	%>
                <p><%=nvv.getTenNv() %></p>
                <a href="#"><i class="fa fa-circle text-success"></i> Online</a>
            </div>
        </div>
        <ul class="sidebar-menu" data-widget="tree">
            <li class="active"><a href="${pageContext.request.contextPath}/home.jsp"> <i
                        class="fa fa-dashboard"></i> <span>Tổng quan</span>
                </a></li>
            <li class="treeview"><a href="#"> <i class="fa fa-dashboard"></i>
                    <span>Quản lí hàng hóa</span> <span class="pull-right-container">
                        <i class="fa fa-angle-left pull-right"></i>
                    </span>
                </a>
                <ul class="treeview-menu">
                    <li class=""><a href="${pageContext.request.contextPath}/addNewSP.jsp"><i
                                class="fa fa-circle-o"></i>Thêm mới</a></li>
                                
                    <li><a href="${pageContext.request.contextPath}/ddh.jsp"><i
                                class="fa fa-circle-o"></i>Nhập hàng</a></li>
                                
                    <li><a href="${pageContext.request.contextPath}/createbill.jsp"><i
                                class="fa fa-circle-o"></i>Bán hàng</a></li>
                                
                    <li><a href="${pageContext.request.contextPath}/hanghoa.jsp"><i
                                class="fa fa-circle-o"></i>Hàng hóa</a></li>
                                
                    <li><a href="${pageContext.request.contextPath}/DanhMucSP.jsp"><i
                                class="fa fa-circle-o"></i>Danh mục hàng hóa</a></li>
                                
                    <li><a href="${pageContext.request.contextPath}/LoaiSP.jsp"><i
                                class="fa fa-circle-o"></i>Loại sản phẩm</a></li>
                    
                    <li><a href="${pageContext.request.contextPath}/hoadon.jsp"><i
                                class="fa fa-circle-o"></i>Hóa đơn</a></li>
                    
                </ul></li>
            <li class="treeview"><a href="#"> <i class="fa fa-dashboard"></i>
                    <span>Nhà cung cấp</span> <span class="pull-right-container">
                        <i class="fa fa-angle-left pull-right"></i>
                    </span>
                </a>
                <ul class="treeview-menu">
                    <li class=""><a href="${pageContext.request.contextPath}/nhacc.jsp"><i
                                class="fa fa-circle-o"></i>Quản lí</a></li>
                </ul></li>
            <li class="treeview"><a href="#"> <i class="fa fa-dashboard"></i>
                    <span>Khách hàng</span> <span class="pull-right-container">
                        <i class="fa fa-angle-left pull-right"></i>
                    </span>
                </a>
                <ul class="treeview-menu">
                    <li class=""><a href="${pageContext.request.contextPath}/KhachHang.jsp"><i
                                class="fa fa-circle-o"></i>Quản lí</a></li>
                </ul></li>
            <li class="treeview"><a href="#"> <i class="fa fa-dashboard"></i>
                    <span>Nhân viên</span> <span class="pull-right-container"> <i
                            class="fa fa-angle-left pull-right"></i>
                    </span>
                </a>
                <ul class="treeview-menu">
                <%
                	if(nvv.getTenNv().equals("Admin"))
                	{
                		
                	
                %>
                    <li class=""><a href="${pageContext.request.contextPath}/employee.jsp"><i
                                class="fa fa-circle-o"></i>Quản lí</a></li>
                <% }%>
                    <li><a href="${pageContext.request.contextPath}/tinhluong.jsp"><i class="fa fa-circle-o"></i>Tính
                            lương</a></li>
                </ul></li>
            <li><a href="${pageContext.request.contextPath}/calam.jsp"> <i
                        class="fa fa-dashboard"></i> <span>Ca làm</span>
                </a></li>
            <li><a href="${pageContext.request.contextPath}/chamcong.jsp"> <i
                        class="fa fa-dashboard"></i> <span>Chấm công</span>
                </a></li>
            <li><a href="${pageContext.request.contextPath}/thuongphat.jsp"> <i
                        class="fa fa-dashboard"></i> <span>Thưởng phạt</span>
                </a></li>
            <!-- NHÉT CÁI DANH MỤC NHÉ -->
        </ul>
    </section>
    <!-- /.sidebar -->
</aside>