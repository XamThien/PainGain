<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
         
<%@page import="java.util.*" %>
<%@page import ="java.io.IOException" %>
<%@page import="model.*" %>
<%@page import="DAO.*" %>
<title>Pain&Gain | Trang Chủ Quản Lý </title>
<%@include file="frame/header.jsp"%>
<%@include file="frame/sidebar.jsp"%>
<div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
        <h1>
            Trang chủ
            <small>Tổng quan</small>
        </h1>
        <ol class="breadcrumb">
            <li><a href="#"><i class="fa fa-dashboard"></i>Home</a></li>
            <li class="active">Tổng quan</li>
        </ol>
    </section>
    <section class="content">
    
    
        <!-- Small boxes (Stat box) -->
        <div class="row">
            <div class="box box-default color-palette-box">
                <div class="box-header with-border">
                    <h3 class="box-title"><i class="fa fa-tag"></i>Thông tin giao dịch trong ngày: </h3>
                </div>
                <div class="box-body">
                    <div class="col-lg-3 col-xs-6">
                        <!-- small box -->
                        <div class="small-box bg-aqua">
                        
                            <div class="inner">
                                <h3>xxx1</h3>

                                <p>Số đơn đặt hàng</p>
                            </div>
                            
                            <div class="icon">
                                <i class="ion ion-bag"></i>
                            </div>
                            <a href="ddhtrongngay.jsp" class="small-box-footer">Thông tin chi tiết <i class="fa fa-arrow-circle-right"></i></a>
                        </div>
                    </div>
                    <!-- ./col -->
                    <div class="col-lg-3 col-xs-6">
                        <!-- small box -->
                        <div class="small-box bg-green">
                        
                            <div class="inner">
                                <h3>xxx2</h3>

                                <p>Hàng hóa nhập</p>
                            </div>
                            
                            <div class="icon">
                                <i class="ion ion-bag"></i>
                            </div>
                            <a href="#" class="small-box-footer"> .</a>
                        </div>
                    </div>
                    <!-- ./col -->
                    <div class="col-lg-3 col-xs-6">
                        <!-- small box -->
                        <div class="small-box bg-yellow">
                         
                            <div class="inner">
                                <h3>xx3</h3>

                                <p>Hóa đơn bán hàng</p>
                            </div>
                            <div class="icon">
                                <i class="ion ion ion-bag"></i>
                            </div>
                            
                            <a href="hoadontrongngay.jsp" class="small-box-footer">Thông tin chi tiết <i class="fa fa-arrow-circle-right"></i></a>
                        </div>
                    </div>
                    <!-- ./col -->

                    <!-- /.box-body -->
                </div>
                <!-- small box -->

            </div>
            <div class="box box-default color-palette-box">
                <div class="box-header with-border">
                    <h3 class="box-title"><i class="fa fa-tag"></i>Nhật ký hoạt động</h3>
                </div>
                <div class="box-body">
                    <section class="content">
                        <div class="row">
                            <div class="col-md-12">
                                <!-- The time line -->
                                <ul class="timeline">
                                <h3>Chưa có gì cả.</h3>
                                
                                
                                    <!-- timeline time label -->
                                    <li class="time-label">
                                        <span class="bg-red" >
                                            <span class="time"><i class="fa fa-clock-o"></i> Giờ</span>
                                        </span>
                                    </li>
                                    <!-- /.timeline-label -->
                                    <!-- timeline item -->
                                    <li>
                                        <i class="fa fa-user bg-aqua"></i>

                                        <div class="timeline-item">
                                            <span class="time"> Ngày</span>
                                            <h3 class="timeline-header no-border">Nội dung</h3>
                                        </div>
                                    </li>
                                    <!-- END timeline item -->
                                    <!-- timeline item -->
                                    
                                   

                                </ul>
                            </div>
                            <!-- /.col -->
                        </div>
                    </section>
                </div>
                <!-- /.box-body -->
            </div>
        </div>
    </section>
</div>
<%@include file="frame/footer.jsp"%>