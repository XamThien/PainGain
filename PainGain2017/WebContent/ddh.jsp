<%-- 
    Document   : dsdondathang
    Created on : Jun 21, 2017, 9:54:24 PM
    Author     : Asus
--%>

<%@page import="DAO.*"%>
<%@page import="java.util.List"%>
<%@page import="model.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@include file="frame/header.jsp"%>
<%@include file="frame/sidebar.jsp"%>
<div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
        <h1>
            Quản lí hàng hóa
            <small>Danh sách đơn đặt hàng</small>
        </h1>
        <ol class="breadcrumb">
            <li><a href="home.jsp"><i class="fa fa-dashboard"></i>Home</a></li>
            <li class="active">Nhập hàng</li>
        </ol>
    </section>
    <section class="content">
        <!-- Small boxes (Stat box) -->
        <div class="row">
            <div class="col-md-10">
                <div class="box box-primary">

                    <!-- /.box-header -->
                    <div class="box-body">
                        <table id="example1" class="table table-bordered table-striped table-hover">
                            <thead>
                                <tr>
                                    <th>Mã Đơn đặt hàng</th>
                                    <th>Ngày lập</th>
                                    <th>Tổng giá trị</th>
                                    <th></th>
                                </tr>
                            </thead>
                            <tbody>
                                <%
                                    List<PhieuNhap> lst = new PhieuNhapDAO().getAllPhieuNhap();
                                    for (PhieuNhap pn : lst) {
                                    	List<ChiTietPhieuNhap> lstt = new ChiTietPhieuNhapDAO().getAllChiTietPhieuNhap(pn.getMaPn());
                                    	int tonggt = 0;
                                    	for (ChiTietPhieuNhap ctpn : lstt)
                                    	{
                                    		tonggt+= ctpn.getDonGia()*ctpn.getSoLuong();
                                    	}
                                    	int htonggt = tonggt/1000;
                                    	int mtonggt = htonggt/1000;
                                %>
                                <tr>
                                    <td><%=pn.getMaPn()%></td>
                                    <td><%=pn.getNgayLap()%></td>
                            		<td><%=(mtonggt>0 ? mtonggt+"."+htonggt%1000 : htonggt)%>.000 VNĐ</td>
                                	<td><a href="chitietddh.jsp?Ma_Pn=<%=pn.getMaPn()%>"> Chi tiết</a></td>
                            
                            </tr>
                            <%}%>
                            </tbody>
                            <tfoot>
                                <tr>
                                    <th>Mã Đơn đặt hàng</th>
                                    <th>Ngày lập</th>
                                    <th>Tổng giá trị</th>
                                    <th></th>
                                </tr>
                            </tfoot>
                        </table>
                    </div>
                    <!-- /.box-body -->
                </div>
            </div>
            <div class="col-md-2">
                <a href="addondh.jsp"> <button type="button" class="btn btn-primary" > Tạo đơn đặt hàng</button></a>

            </div>
        </div>
    </section>
</div>
<%@include file="frame/footer.jsp"%>
