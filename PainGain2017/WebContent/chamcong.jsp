  <%-- 
    Document   : dsdondathang
    Created on : Jun 21, 2017, 9:54:24 PM
    Author     : Asus
--%>
<%@page import="java.util.List"%>


<%@page import ="java.io.IOException" %>
<%@page import="DAO.*"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.*"%>
<%@page import="java.util.*"%>
<%@page import="java.text.*"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@include file="frame/header.jsp"%>
<%@include file="frame/sidebar.jsp"%>

<div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
    <%
    String month = request.getParameter("month");
    String year = request.getParameter("year");
    String date;
    Date dNow = new Date( );
    SimpleDateFormat ftt = new SimpleDateFormat ("yyyy");
    int curyear =  Integer.parseInt(ftt.format(dNow));
    
    String starttime = (String) sessi.getAttribute("curtime");
    
    if(month!=null && year!=null)
    {
    	date = year+"-"+month+"-10";
    }
    else
    {
    	SimpleDateFormat ft = new SimpleDateFormat ("MM");
        month =  ft.format(dNow);
        SimpleDateFormat fttyear = new SimpleDateFormat ("yyyy-MM-dd");
        date =  fttyear.format(dNow);
        
        SimpleDateFormat fttt = new SimpleDateFormat ("yyyy");
        year= fttt.format(dNow);
    }
    // selected ma ca khi bat dau cham cong
    SimpleDateFormat hourft = new SimpleDateFormat ("HH");
    int curhour =  Integer.parseInt(hourft.format(dNow));
    int cktime =0;
    if (curhour >= 8  && curhour < 12) {cktime = 1;}
    if (curhour >= 12 && curhour < 16) {cktime = 2;}
    if (curhour >= 16 && curhour < 21) {cktime = 3;}
    
    
    
    
    %>
        
        <span style="color:red"><i>${msg}</i></span>
        <form class="formtl" action="chamcong.jsp" method="get">
				<ul class="ulstyle" >
					<li><a href="#"><i class="fa fa-dashboard"></i>Tháng: </a></li>
					
					<li>
							
								<select  id="monthx"  name="month"  >
								<%
			                    	for(int i=1; i<13;i++)
			                    	{
			                    		
			                    		
			                    %>
			                     <option value="<%=i%>"> Tháng <%=i %> </option> 
			                     
									
								<%} %>
								
								</select>
							
					</li>
					<li>
							
								<select  id="yearx"  name="year"  >
								<%
			                    	for(int j=2017; j<curyear+1;j++)
			                    	{
			                    		
			                    		
			                    %>
			                     <option value="<%=j%>"> Năm <%=j %> </option> 
			                     
									
								<%} %>
								
								</select>
							
					</li>
					<li>
						<input class = "btn btn-link" type="submit" value="Chi tiết">
					</li>
				</ul>
				
		</form>
		<h1>
            Bảng chấm công tháng <%=month %> năm <%=year %>
           
        </h1>
    </section>
    
    <section class="content">
        <!-- Small boxes (Stat box) -->
        <div class="row" style="margin-top: 10px;">
            <div class="col-md-10">
                <div class="box box-primary">

                    <!-- /.box-header -->
                    <div class="box-body">
                        <table id="example1" class="table table-bordered table-striped table-hover">
                            <thead>
                                <tr>
                                    <th>STT</th>
                                    <th>Giờ bắt đầu</th>
                                    <th>Giờ kết thúc</th>
                                    <th>Ngày</th>
                                    <th>Mã ca</th>
                                </tr>
                            </thead>
                            <tbody>
                                <%
                                HttpSession sessx = request.getSession();
            	                Account acc = (Account)sessx.getAttribute("login");
            	                
                                List<ChamCong> list = new ArrayList<ChamCong>();
                                try 
                                {
                                	int i=0;
                                	list = new ChamCongDAO().getAllChamCong(acc.getMaAc(),date);
                                    for (ChamCong cc : list) 
                                    {
                                %>
                                <tr>
                                    <td><%=++i%></td>
                                    <td><%=cc.getGioBatDau() %></td>
                                    <td><%=cc.getGioKetThuc()%></td>
                                    <td><%=cc.getNgay() %></td>
                                    <td><%=cc.getMaCa() %></td>
                            
                                
                              <%   
                              		}
                              %>
                            
                            </tr>
                            <%
                                }
	                            
	                            catch (Exception e)
	                            {}
                              
                            %>
                            </tbody>
                            <tfoot>
                                <tr>
                                    <th>Mã chấm công</th>
                                    <th>Giờ bắt đầu</th>
                                    <th>Giờ kết thúc</th>
                                    <th>Ngày</th>
                                    <th>Mã ca</th>                                
                                </tr>
                            </tfoot>
                        </table>
                    </div>
                    <!-- /.box-body -->
                </div>
            </div>
            <div class="col-md-2">
                <button class="btn btn-primary" id="btnaddemployee" data-toggle="modal" data-target="#addnew" onclick="getendtime();">Chấm công hôm nay</button>

            </div>
        </div>
    </section>
    <!-- ===================================================================================== -->
   
    <div class="modal  fade" id="addnew">
          <div class="modal-dialog" >
            <div class="modal-content">
              <div class="modal-header with-border">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                  <span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title">Chấm công</h4>
              </div>
              
                <form class="form-horizontal" action="addchamcong" method="post">
              <div class="modal-body">
        			<input type="hidden" value="<%=nvv.getMaNv() %>" name="ID">
                 <div class="form-group">
                  <label for="inputText1" class="col-sm-2 control-label">Giờ bắt đầu</label>
                  <div class="col-sm-10">
                  	<input type="hidden"  id="inputText131"  name="ID">
                    <input type="time"  class="form-control" id="inputText11"  name="gbd" value="<%=starttime %>" >
                  </div>
                </div>
                  <div class="form-group">
                  <label for="inputText2" class="col-sm-2 control-label">Giờ kết thúc</label>
                  <div class="col-sm-10">
                    <input type="time" class="form-control" id="inputText12"  name="gkt" >
                  </div>
                </div>
                
                
                
                
                <div class="form-group">
                  <label for="inputText5" class="col-sm-2 control-label">Ca làm</label>
                  <div class="col-sm-10">
                    
					<select class="form-control" id="inputText2"  name="ma_ca"  >
					<%
                    List<CaLam> lst =  new  CaLamDAO().getAllCaLam();
                	if (list != null) 
                	{
                		for (CaLam cl : lst)
                		{
                    %>
						<option value="<%=cl.getMaCa() %>" <% if (cktime == cl.getMaCa()) {out.print("selected");}  %> >Ca <%=cl.getMaCa() %> : <%=cl.getGioBatDau() %> - <%=cl.getGioKetThuc() %></option>
					<%}} %>
					</select>
                  </div>
                  
                </div>
                  
                </div>
                  
             
              <div class="modal-footer">
                <button type="button" class="btn btn-default pull-left" data-dismiss="modal">Close</button>
                
                <button type="submit" class="btn btn-primary" >Lưu</button>
              </div>
            </form>
            </div>
            <!-- /.modal-content -->
          </div>
          <!-- /.modal-dialog -->
        </div>
     <!-- ===================================================================================== -->
</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript">
function getendtime(){  
	  $('#inputText12').each(function(){    
	    var d = new Date(),        
	        h = d.getHours(),
	        m = d.getMinutes();
        	s= d.getSeconds();
	    if(h < 10) h = '0' + h; 
	    if(m < 10) m = '0' + m; 
	    if(s < 10) m = '0' + s; 
	    $(this).attr({
	      'value': h + ':' + m+ ':' + s
	    });
	  });
	}

</script>
<%@include file="frame/footer.jsp"%>
