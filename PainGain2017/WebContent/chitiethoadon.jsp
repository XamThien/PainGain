<%-- 
    Document   : loai san pham
    Created on : Jun 11, 2017, 2:27:50 PM
    Author     : dangt
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="model.*" %>
<%@ page import="DAO.*" %>
<title>Hoá đơn bán hàng</title>
<%@include file="frame/header.jsp" %>
<script language="javascript">
              function confirmAction() {
      		return confirm("Xác nhận xóa:")
	}
</script>
<%@include file="frame/sidebar.jsp" %>
<div class="content-wrapper">
    <section class="content-header">
         <h1>
            Chi tiết hoá đơn
        </h1>
        <span style="color:red"><i>${msg}</i></span>
        <ol class="breadcrumb">
            <li><a href="home.jsp"><i class="fa fa-dashboard"></i>Home</a></li>
            <li><a href="${pageContext.request.contextPath}/hoadon.jsp">Hóa đơn</a></li>
            <li class="active">Chi tiết hóa đơn</li>
        </ol>
    </section>
    <section class="content">
        <!-- Small boxes (Stat box) -->
        			<%
                    	int mahd = Integer.parseInt(request.getParameter("MaHD"));
                        HoaDon hd = new HoaDonDAO().getHoaDon(mahd);
                        if(hd!=null)
                        {
                        	try
                        	{
                        		KhachHang kh = new KhachHangDAO().getKhachHang(hd.getMaKh());
                                int tonggt = 0;
                                
                                List<ChiTietHoaDon> lstcthd = new ChiTietHoaDonDAO().getAllChiTietHoaDon(mahd);
                                for (ChiTietHoaDon cthd : lstcthd)
                                {
                                	int pt = 0;
                           			if (cthd.getLaPhanTram()==true)
                           			{
                           				pt=1;
                           			}
                                	SanPham sp = new SanPhamDAO().getSanPham(cthd.getMaSp());
                                	tonggt+= cthd.getSoLuong()*sp.getDonGiaBan() - cthd.getGiamGia()*pt*cthd.getSoLuong()*sp.getDonGiaBan()/100 ;
                                	
                                }
                        	tonggt=tonggt/1000;
                        	int ntong = tonggt/1000;
                        	
                        
                    %>
        <div class="box box-default">
            <div class="box-header with-border">
                <h3 class="box-title">Thông tin Hóa đơn</h3>

                <div class="box-tools pull-right">
                    <button type="button" class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i></button>
                </div>
            </div>
            <div class="box-body">
                <div class="row">
                
                    
                    <div class="col-md-6">
                        
                        <div class="form-group">
                            <label>Tên khách hàng:</label>
                            <h3 class="text-muted" style=" margin: 0px;margin-left: 20px;"><%=kh.getTenKh()%></h3>
                        </div>
                        <div class="form-group">
                            <label>Số điện thoại:</label>
                            <h3 class="text-muted" style=" margin: 0px;margin-left: 20px;"><%=kh.getSoDt()%></h3>
                        </div>
                        <div class="form-group">
                            <label>Địa chỉ:</label>
                            <h3 class="text-muted" style=" margin: 0px;margin-left: 20px;"><%=kh.getDiaChi() %></h3>
                        </div>
                    </div>
                    <!-- /.col -->
                    <div class="col-md-6">
                        <!-- /.form-group -->
                        
                        <div class="form-group">
                            <label>Ngày lập:</label>
                            <h3 class="text-muted" style=" margin: 0px;margin-left: 20px;"><%=hd.getNgayLap()%></h3>
                        </div>
                        
                        <div class="form-group">
                            <label>Tổng giá trị:</label>
                            <h3 class="text-muted" style=" margin: 0px;margin-left: 20px;"><%=(ntong >0) ? ( ntong+"."+tonggt%1000) : tonggt %>.000 VNĐ</h3>
                        </div>
                        <!-- /.form-group -->
                    </div>
                    <!-- /.col -->
                </div>
                <!-- /.row -->
            </div>
        </div>
			        <%}
			          catch (Exception e)
			                        	{
			        	  					out.println(e);
			                        	}
			          } %>
        <div class="box">
            <!-- /.box-header -->
            <div class="box-body">
                <table id="example1" class="table table-bordered table-striped table-hover">
                    <thead>
                        <tr>
                            <th>STT</th>
                            
                            <th>Tên hàng</th>
                            <th width="125px">Đơn giá</th>
                            <th width="88px">Số lượng</th>
                            <th width="75px">Giảm giá</th>
                            <th>Thành tiền</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%
                        if(hd!=null)
                        {
                        	try
                        	{
                        		int i=0;
                                List<ChiTietHoaDon> lstcthd = new ChiTietHoaDonDAO().getAllChiTietHoaDon(mahd);
                                for (ChiTietHoaDon cthd : lstcthd)
                                {
                                	SanPham sp = new SanPhamDAO().getSanPham(cthd.getMaSp());
                           			int pt = 0;
                           			if (cthd.getLaPhanTram()==true)
                           			{
                           				pt=1;
                           			}
                        %>
                        <tr>
                            <td><%=++i %></td>
                            
                            <td><%=sp.getTenSp() %></td>
                            <%
                            	int dongia= sp.getDonGiaBan();
	                            int hdongia = dongia/1000;
	                        	int mdongia = hdongia/1000;
                            %>
                            <td><%=(mdongia>0 ? mdongia+"."+hdongia%1000 : hdongia)%>.000 VNĐ</td>
                            <td><%=cthd.getSoLuong() %></td>
                            <td><%=cthd.getGiamGia() %>%</td>
                            <%
                            	int tonggt = cthd.getSoLuong()*sp.getDonGiaBan() - cthd.getGiamGia()*pt*cthd.getSoLuong()*sp.getDonGiaBan()/100;
	                            int htonggt = tonggt/1000;
	                        	int mtonggt = htonggt/1000;
                            %>
                            <td><%=(mtonggt>0 ? mtonggt+"."+htonggt%1000 : htonggt)%>.000 VNĐ</td>
                        </tr>
                       <%
                                }
                        	}
                        	catch (Exception ex)
                        	{
                        		
                        	}
                        }
                       %>
                    </tbody>
                    <tfoot>
                        <tr>
                            <th>STT</th>
                            
                            <th>Tên hàng</th>
                            <th width="125px">Đơn giá</th>
                            <th width="88px">Số lượng</th>
                            <th width="75px">Giảm giá</th>
                            <th>Thành tiền</th>
                        </tr>
                    </tfoot>
                </table>
            </div>
            <!-- /.box-body -->
        </div>
    </section>
    <!-- =============================================================================== -->
  
 

  <!-- ===============================================================================  -->
</div>
<%@include file="frame/footer.jsp" %>
