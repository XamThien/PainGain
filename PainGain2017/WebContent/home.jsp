<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
         

<%@page import="java.util.*"%>
<%@page import="java.text.*"%>
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
        <form class="formtlx" method="get" action="home.jsp">
        <ul class="homeulstyle">
        	<li >Ngày:</li>
            <li><input type="date" class="rounded" name="viewdate" required="required"></li>
            <li class="active"><button type="submit" class="btn btn-link">Xem</button></li>
        </ul>
        </form>
    </section>
    <section class="content">
    
    
        <!-- Small boxes (Stat box) -->
        <div class="row">
            
            <!-- ====================================================================================== -->
            <div class="box box-default color-palette-box">
            <%
            			String dayx= null;
            			dayx= request.getParameter("viewdate");
            			
            
					    Date dNow = new Date( );
					    SimpleDateFormat fttt = new SimpleDateFormat ("yyyy-MM-dd");
					    
					    
					    String date="";
					    if(dayx==null)
					    {
					    	date = fttt.format(dNow);
					    }
					    else
					    {
					    	Date d1 = null;
						    d1 = fttt.parse(dayx);
					    	date= fttt.format(d1);
					    }
					    
					    
					    List<HoaDon>lst1=null;
					    try
					    {
					    	lst1= new HoaDonDAO().getOnDayHoaDon(date);
					    }
					    catch (Exception e1)
					    {}
					    
					    int SHD = 0;
					    if(lst1!=null)
					    {
					    	SHD = lst1.size();
					    }
					   
			%>
                <div class="box-header with-border">
                    <h3 class="box-title"><i class="fa fa-tag"></i>Thông tin giao dịch trong ngày: <%=date %></h3>
                </div>
                <div class="box-body">
                    <div class="col-lg-3 col-xs-6">
                        <!-- small box -->
                        <div class="small-box bg-aqua">
                        
					    
                            <div class="inner">
                            	<p>Hoá đơn bán hàng:</p>
                                <h3><%=SHD %></h3>
                            </div>
                          
                            <div class="icon">
                                <i class="ion ion-bag"></i>
                            </div>
                            <a href="hoadon.jsp?viewdate=<%=date %>" class="small-box-footer">Thông tin chi tiết <i class="fa fa-arrow-circle-right"></i></a>
                        </div>
                    </div>
                    <!-- ./col -->
                    <div class="col-lg-3 col-xs-6">
                        <!-- small box -->
                        <div class="small-box bg-green">
                        
					    <%
					    	int tonggt=0;
					    	int htonggt=0;
					    	int mtonggt=0;
					    	if(lst1!=null)
					    	{
					    		for (HoaDon hd : lst1)
					    		{
					    			List<ChiTietHoaDon> lst = null;
					    			lst = new ChiTietHoaDonDAO().getAllChiTietHoaDon(hd.getMaHd());
					    			for (ChiTietHoaDon cthd : lst)
					    			{
					    				tonggt += (int) (cthd.getSoLuong()*cthd.getDonGia()-cthd.getSoLuong()*cthd.getDonGia()*cthd.getGiamGia()*0.01);
					    			}
					    			lst.clear();
					    		}
					    		
					    	}
					    	 int tongban= tonggt;
					    	 htonggt = tonggt/1000;
                        	 mtonggt = htonggt/1000;
					    		
					    %>
                            <div class="inner">
                            	<p>Tổng giá trị hoá đơn:</p>
                                <h3><%=(mtonggt>0 ? mtonggt+"."+htonggt%1000 : htonggt)%>.000</h3> 
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
                         
					    <%
					    int tonggoc= 0;
					    
					    if(lst1!=null)
				    	{
				    		for (HoaDon hd : lst1)
				    		{
				    			List<ChiTietHoaDon> lst = null;
				    			lst = new ChiTietHoaDonDAO().getAllChiTietHoaDon(hd.getMaHd());
				    			for (ChiTietHoaDon cthd : lst)
				    			{
				    				SanPham sp = new SanPhamDAO().getSanPham(cthd.getMaSp());
				    				tonggoc +=  cthd.getSoLuong()*sp.getDonGiaMua();
				    			}
				    			lst.clear();
				    		}
				    		
				    	}
					    int loinhuan = tongban - tonggoc;
					    int hloinhuan =0;
					    int mloinhuan=0;
					    hloinhuan = loinhuan/1000;
                   	 	mloinhuan = hloinhuan/1000;
					    
					    			
					    		
					    %>
                            <div class="inner">
                            	<p>Lợi nhuận bán hàng:</p>
                                <h3><%=(mloinhuan>0 ? mloinhuan+"."+hloinhuan%1000 : hloinhuan)%>.000 </h3>
							 </div>
                            <div class="icon">
                                <i class="ion ion ion-bag"></i>
                            </div>
                           
                            <a href="#" class="small-box-footer"> .</a>
                        </div>
                    </div>
                    <!-- ./col -->

                    <!-- /.box-body -->
                </div>
                <!-- small box -->

            </div>            
            <!-- ====================================================================================== -->
            <div class="box box-default color-palette-box">
                <div class="box-header with-border">
                    <h3 class="box-title"><i class="fa fa-tag"></i> Chúc Mừng Năm Mới: </h3>
                </div>
                <div class="box-body">
                    <img style="width: 1097px;" src="${pageContext.request.contextPath}/images/paingain.jpg" 
                     alt="Chúc mừng năm mới">
                    <!-- ./col -->

                    <!-- /.box-body -->
                </div>
                <!-- small box -->

            </div>
            <!-- ====================================================================================== -->
            <div class="box box-default color-palette-box">
                <div class="box-header with-border">
                    <h3 class="box-title"><i class="fa fa-tag"></i>Thông báo :</h3>
                </div>
                <div class="box-body">
                    <section class="content">
                        <div class="row">
                            <div class="col-md-12">
                                <!-- The time line -->
                                <ul class="timeline">
                                
                                <%
                                
                                SimpleDateFormat ftt = new SimpleDateFormat ("dd-MM-yyyy");
                                String day =  ftt.format(dNow);
                                
                                SimpleDateFormat hftt = new SimpleDateFormat ("HH:mm");
                                String ho =  hftt.format(dNow);
                                %>
                                
                                    <!-- timeline time label -->
                                    <li class="time-label">
                                        <span class="bg-red" >
                                            <span class="time"><i class="fa fa-clock-o"></i> <%=ho %></span>
                                        </span>
                                    </li>
                                    <!-- /.timeline-label -->
                                    <!-- timeline item -->
                                    <li>
                                        <i class="fa fa-user bg-aqua"></i>

                                        <div class="timeline-item">
                                            <span class="time"> <%=day %></span>
                                            <h3 class="timeline-header no-border">Chưa Có Nội dung</h3>
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