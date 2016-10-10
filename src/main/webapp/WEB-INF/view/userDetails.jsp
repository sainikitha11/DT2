<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

				<form:form commandName="order" class="form-horizaontal">
				<div class="span9 margin-top">
                   <div class="span9 center margin-bottom"> 
					<h3>Enter Your Details</h3>
					</div>
						<div class="span4 no_margin_left">
						<legend>Your Personal Details</legend>
					  <div class="control-group">
						<label class="control-label">Name</label>
						<div class="controls docs-input-sizes">
            				<form:input path="cart.user.firstName"  class="form-Control"/>
						</div>
					  </div>
					  <div class="control-group">
						<label class="control-label">Email</label>
						<div class="controls docs-input-sizes">
						  <form:input path="cart.user.mail"  class="form-Control"/>
						</div>
					  </div>					  				 
					  </div>
					  <div class="span2 no_margin_left">
					  <input type="hidden" name="_flowExecutionKey" />
						<input type="submit" value="Continue" class="btn btn-primary pull-left" name="_eventId_userInfoProcessCompleted" />
						 </div>
						 <div class="span1 no_margin_left">
					 	<button class="btn btn-danger pull-left " name="_eventId_cancel">Cancel</button>
					    </div>
					  </div>
					    </form:form>
				</div>
			</div>
		</div>
 </div>	
	 <footer>
	 
<script type="text/javascript" src="<c:url value="/resources/js/jquery-2.2.0.min.js" />"></script>
<script src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>
<script src="<c:url value="/resources/js/jquery.rating.pack.js"/>"></script>

</body></html>
	
		