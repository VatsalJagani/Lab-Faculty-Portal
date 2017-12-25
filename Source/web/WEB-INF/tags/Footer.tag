<%-- 
    Document   : Footer
    Created on : Jan 25, 2017, 9:36:52 PM
    Author     : VATSAL
--%>

<%@tag description="This is footer" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
</div>
		<div>
                    <p class="text-right foot">Copyright &copy; <a href="#">DDU</a>. All Rights Reserved. &emsp;</p>
                        <p class="text-right foot">Designed by <a target="" href="#">Students of Computer Department</a>, guided by <a target="" href="#">Pro. SHIDDHARTH P. SHAH</a>. &emsp;</p>
		</div>
    </div>
          <c:if test="${(param.msg != null) || (!empty requestScope.msg)}">
    <div id="myModal" class="modal fade" role="dialog">
  <div class="modal-dialog">
    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
        <h4 class="modal-title">Message</h4>
      </div>
      <div class="modal-body">
          <p>${requestScope.msg} ${param.msg}</p>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
      </div>
    </div>
  </div>
</div>

            <script type="text/javascript">
		window.onload = function() {
			$('#myModal').modal('show');
		};
            </script>
          </c:if>
</body>
</html>