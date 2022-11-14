<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     </div>
        <!-- /#page-wrapper -->
    </div>
    <form id="actionForm" method="get" >
		<input type="hidden" name="pageNum" value="${!empty param.pageNum? param.pageNum : '1'}" />
		<input type='hidden' name="action" value='${param.action}'/>
		<input type='hidden' name='bno' value='${param.bno}' />
		<input type='hidden' name='type' value='<c:out value="${param.type}"/>'>
		<input type='hidden' name='keyword' value='<c:out value="${param.keyword}"/>'>
	</form>
</body>

</html>
