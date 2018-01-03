<%-- 
    Document   : chitietddh
    Created on : Jun 21, 2017, 10:43:51 PM
    Author     : Asus
--%>

<%@page import="model.*"%>
<%@page import="DAO.*"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@include file="frame/header.jsp"%>
<%@include file="frame/sidebar.jsp"%>
<div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
        <h1>
            Trang chủ
            <small>Quản lí hàng hóa</small>
        </h1>
        <ol class="breadcrumb">
            <li><a href="home.jsp"><i class="fa fa-dashboard"></i>Home</a></li>
            <li><a href="ddh.jsp">Danh sách đơn đặt hàng</li></a>
            <li class="active">Chi tiết đơn đặt hàng</li>
        </ol>
    </section>
    <section class="content">
        <!-- Small boxes (Stat box) -->
        
           
        
        
        <div class="box">
            <!-- /.box-header -->
            <div class="box-body">
                <table id="example1" class="table table-bordered table-striped table-hover">
                    <thead>
                        <tr>
                            <th>STT</th>
                            <th>Tên hàng</th>
                            <th>Đơn giá nhập</th>
                            <th width="125px">Số lượng</th>
                            <th width="88px">Nhà cung cấp</th>
                            <th>Thành tiền</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%
                            int i = 1;
	                        int mapn = Integer.parseInt(request.getParameter("Ma_Pn"));
	                        List<ChiTietPhieuNhap> lst = new ChiTietPhieuNhapDAO().getAllChiTietPhieuNhap(mapn);
                            for(ChiTietPhieuNhap ctpn : lst)
                            {
                            	SanPham sp = new SanPhamDAO().getSanPham(ctpn.getMaSp());
                            	NhaCc ncc = new NhaCcDAO().getNhaCc(ctpn.getMaNcc());
                            
                           
                        %>
                        <tr>
                            <td><%= i %></td>
                            <td><%=sp.getTenSp() %></td>
                            <%
                            	int dongia = ctpn.getDonGia();
	                            int hdongia = dongia/1000;
	                        	int mdongia = hdongia/1000;
                            %>
                            <td><%=(mdongia>0 ? mdongia+"."+hdongia%1000 : hdongia)%>.000 VNĐ</td>
                            <td><%=ctpn.getSoLuong() %></td>
                            <td><%=ncc.getTenNcc() %></td>
                            <%
                            	int tonggt=0;
                            	tonggt=ctpn.getSoLuong()*ctpn.getDonGia();
                            	int htonggt = tonggt/1000;
                            	int mtonggt = htonggt/1000;
                            %>
                            <td><%=(mtonggt>0 ? mtonggt+"."+htonggt%1000 : htonggt)%>.000 VNĐ</td>
                        </tr>
                        <%
                        	i++;
                        	} 
                        %>
                    </tbody>
                    <tfoot>
                        <tr>
                            <th>STT</th>
                            <th>Tên  hàng</th>
                            <th>Đơn giá nhập</th>
                            <th width="125px">Số lượng</th>
                            <th width="88px">Nhà cung cấp</th>
                            <th>Thành tiền</th>
                        </tr>
                    </tfoot>
                </table>
            </div>
            <!-- /.box-body -->
        </div>
    </section>
</div>
<%@include file="frame/footer.jsp" %>
