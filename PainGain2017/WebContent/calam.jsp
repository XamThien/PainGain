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
         <h1>
            Quản lý ca làm
            
        </h1>
        <span style="color:red"><i>${msg}</i></span>
        
        <ol class="breadcrumb">
            <li><a href="home.jsp"><i class="fa fa-dashboard"></i>Home</a></li>
            <li class="active">Ca làm</li>
        </ol>
    </section>
    
    <section class="content">
        <!-- Small boxes (Stat box) -->
        <div class="box">
            
                <div class="box box-primary">

                    <!-- /.box-header -->
                    <div class="box-body">
                        <table id="example1" class="table table-bordered table-striped table-hover">
                            <thead>
                                <tr>
                                    <th>Ca làm</th>
                                    <th>Giờ bắt đầu</th>
                                    <th>Giờ kết thúc</th>
                                    <th>Lương giờ</th>
                                    <th><button class="btn btn-link" style="padding-left:40px;" id="btnaddemployee" data-toggle="modal" data-target="#add"><span class="fa fa-plus"> Thêm mới</span></button></th>
                                </tr>
                            </thead>
                            <tbody>
                                <%
                               
                                List<CaLam> list = new ArrayList<CaLam>();
                                try 
                                {
                                	list = new CaLamDAO().getAllCaLam();
                                    for (CaLam cc : list) 
                                    {
                                %>
                                <tr>
                                	<td><%=cc.getMaCa()%></td>
                                    <td><%=cc.getGioBatDau()%></td>
                                    <td><%=cc.getGioKetThuc() %></td>
                                    <td><%=cc.getLuongGio()%></td>
                                    <td>
				                      <button class="btn btn-link" data-toggle="modal" data-target="#modal-edit" onclick = "edit('<%=cc.getMaCa() %>','<%=cc.getGioBatDau() %>','<%=cc.getGioKetThuc() %>',<%=cc.getLuongGio() %>);"><span class="fa fa-edit">Sửa</span></button>
				                      <span class="fa" style="margin: 0px 5px;"></span>
				                      <a onclick="return confirmAction()" href="${pageContext.request.contextPath}/actioncalam?MaCa=<%=cc.getMaCa() %>"><span class="fa fa-remove">Xóa</span></a>
				                    </td>
                            
                                
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
                                	<th>Ca làm</th>
                                    <th>Giờ bắt đầu</th>
                                    <th>Giờ kết thúc</th>
                                    <th>Lương giờ</th>                             
                                </tr>
                            </tfoot>
                        </table>
                    </div>
                    <!-- /.box-body -->
                </div>
            
            
        </div>
    </section>
             <!-- ================================================================================================= -->
        <div class="modal  fade" id="add">
          <div class="modal-dialog" >
            <div class="modal-content">
              <div class="modal-header with-border">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                  <span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title">Thêm ca làm việc</h4>
              </div>
              
                <form class="form-horizontal" action="actioncalam?action=add" method="post">
              <div class="modal-body">
        
                 <div class="form-group">
                  <label for="inputText1" class="col-sm-2 control-label">Giờ bắt đầu</label>
                  <div class="col-sm-10">
                    <input type="time" class="form-control" id="inputText1"  name="agbd" required>
                  </div>
                </div>
                  <div class="form-group">
                  <label for="inputText2" class="col-sm-2 control-label">Giờ kết thúc</label>
                  <div class="col-sm-10">
                    <input type="time" class="form-control" id="inputText2"  name="agkt" required>
                  </div>
                </div>
                <div class="form-group">
                  <label for="inputText4" class="col-sm-2 control-label">Lương giờ</label>
                  <div class="col-sm-10">
                    <input type="number" class="form-control" id="inputText4" placeholder="Lương giờ" name="aluong" required>
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
   
    <div class="modal  fade" id="modal-edit">
          <div class="modal-dialog" >
            <div class="modal-content">
              <div class="modal-header with-border">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                  <span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title">Sửa ca làm việc</h4>
              </div>
              
                <form class="form-horizontal" action="actioncalam?action=edit" method="post">
              <div class="modal-body">
        			<div class="form-group">
                  <label for="inputText2" class="col-sm-2 control-label">Ca</label>
                  <div class="col-sm-10">
                    <input type="text" class="form-control"  id="inputText131"  name="ID" >
                  </div>
                </div>
                 <div class="form-group">
                  <label for="inputText1" class="col-sm-2 control-label">Giờ bắt đầu</label>
                  <div class="col-sm-10">
                  	
                    <input type="time" class="form-control" id="inputText11"  name="egbd" required>
                  </div>
                </div>
                  <div class="form-group">
                  <label for="inputText2" class="col-sm-2 control-label">Giờ kết thúc</label>
                  <div class="col-sm-10">
                    <input type="time" class="form-control" id="inputText12"  name="egkt" required>
                  </div>
                </div>
                <div class="form-group">
                  <label for="inputText4" class="col-sm-2 control-label">Lương giờ</label>
                  <div class="col-sm-10">
                    <input type="number" class="form-control" id="inputText13" placeholder="Lương giờ" name="eluong" required>
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
  <script type="text/javascript">
    function edit(ma,giobd,giokt,luong) {

    	
        
        document.getElementById("inputText131").value = ma;
        document.getElementById("inputText11").value = giobd;
        document.getElementById("inputText12").value = giokt;
        document.getElementById("inputText13").value = luong;
        
    };
    
</script>
</div>
<%@include file="frame/footer.jsp"%>
