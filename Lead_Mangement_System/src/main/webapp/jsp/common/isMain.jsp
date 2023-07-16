<%@page import="in.pandit.Entity.UserEntity"%>
<div class="head">
    <div class="col-div-6">
        <span style="font-size:30px;cursor:pointer; color: white;" class="nav"  > Dashboard</span>
        <span style="font-size:30px;cursor:pointer; color: white;" class="nav2"  > Dashboard</span>
    </div>

    <div class="col-div-6">
        <div class="profile">
            
            <img src="img/user.png" class="pro-img" />
            <p style="font-size:20px;">
                <%
                    UserEntity user = (UserEntity)session.getAttribute("user");
                    if(user!=null){
                 %>
                    <%= user.getName() %>
                <%
                    }
                %> <span  style="font-size:12px;">Web Developmemt</span></p>
        </div>
    </div>
    <div class="clearfix"></div>
</div>