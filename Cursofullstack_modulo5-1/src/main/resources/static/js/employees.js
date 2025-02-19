function EmployeesController(opcion) {
	$("#msg").hide();
	$("#msg").removeClass("alert-success").addClass("alert-danger");
	
	switch (opcion) {
	case "list":
		$.ajax({
			type 	: "post",
			url	 	: "/employees/list",
			success	: function(res) {
				$("#employeesTable").bootstrapTable('load', res);
				$("#employeesTable tbody").on('click', 'tr', function() {
					$("#employee_id").val($(this).find("td:eq(0)").text());
					$("#first_name").val($(this).find("td:eq(1)").text());
					$("#last_name").val($(this).find("td:eq(2)").text());
					$("#email").val($(this).find("td:eq(3)").text());
					$("#phone_number").val($(this).find("td:eq(4)").text());
					$("#hire_date").val($(this).find("td:eq(5)").text());
					$("#job_id").val($(this).find("td:eq(6)").text());
					$("#salary").val($(this).find("td:eq(7)").text());
					$("#commission_id").val($(this).find("td:eq(8)").text());
					$("#manager_id").val($(this).find("td:eq(9)").text());
					$("#department_id").val($(this).find("td:eq(10)").text());
					$("#myModal .close").click();
				})
				$("#myModal").modal({show:true})
			},
			error	: function() {
				$("#msg").show();
				$("#msg").html("Error en busqueda de empleados");
			}
				
		});
		break;

	case "get":
		$.ajax({
			type 	: "post",
			url	 	: "/employees/get",
			data	: "employee_id=" + $("#employee_id").val(),

			success	: function(res) {
				if(res == null || res == "") {
					$("#msg").show();
					$("#msg").html("No se encontro el registro");
				} else {
					$("#employee_id").val(res.employee_id);
					$("#first_name").val(res.first_name);
					$("#last_name").val(res.last_name);
					$("#email").val(res.email);
					$("#phone_number").val(res.phone_number);
					$("#hire_date").val(res.hire_date);
					$("#job_id").val(res.job_id);
					$("#salary").val(res.salary);
					$("#commission_id").val(res.commission_id);
					$("#manager_id").val(res.manager_id);
					$("#department_id").val(res.department_id);
				}
			},
			error	: function() {
				$("#msg").show();
				$("#msg").html("Error en busqueda de empleados");
			}
				
		});
		break;
		
	case "insert":
		var json = 
			{
				'employee_id'	: $("#employee_id").val(),
				'first_name'	: $("#first_name").val(),
				'last_name'		: $("#last_name").val(),
				'email'			: $("#email").val(),
				'phone_number'	: $("#phone_number").val(),
				'hire_date'		: $("#hire_date").val(),
				'job_id'		: $("#job_id").val(),
				'salary'		: $("#salary").val(),
				'commission_id'	: ( $("#commission_id").val() ? $("#commission_id").val() : 0 ),
				'manager_id'	: $("#manager_id").val(),
				'department_id'	: $("#department_id").val(),
			}
		
		var postData = JSON.stringify(json);
		
		$.ajax({
			type 	: "post",
			url	 	: "/employees/insert",
			data	: postData,
			contentType : "application/json; charset=utf-8",
			success	: function(res) {
				if(res == 1) {
					$("#msg").removeClass("alert-danger").addClass("alert-success");
					$("#msg").show();
					$("#msg").html("Registro insertado correctamente");
				} else {
					$("#msg").show();
					$("#msg").html("No se pudo ingresar registro");
				}
			},
			error	: function() {
				$("#msg").show();
				$("#msg").html("Error ingrese empleado nuevamente");
			}
				
		});
		break;
		
	case "update":
		var json = 
			{
				'employee_id'	: $("#employee_id").val(),
				'first_name'	: $("#first_name").val(),
				'last_name'		: $("#last_name").val(),
				'email'			: $("#email").val(),
				'phone_number'	: $("#phone_number").val(),
				'hire_date'		: $("#hire_date").val(),
				'job_id'		: $("#job_id").val(),
				'salary'		: $("#salary").val(),
				'commission_id'	: ( $("#commission_id").val() ? $("#commission_id").val() : 0 ),
				'manager_id'	: $("#manager_id").val(),
				'department_id'	: $("#department_id").val(),
			}
		
		var postData = JSON.stringify(json);
		
		$.ajax({
			type 	: "post",
			url	 	: "/employees/update",
			data	: postData,
			contentType : "application/json; charset=utf-8",
			success	: function(res) {
				if(res == 1) {
					$("#msg").removeClass("alert-danger").addClass("alert-success");
					$("#msg").show();
					$("#msg").html("Registro actualizado correctamente");
				} else {
					$("#msg").show();
					$("#msg").html("No se pudo actualizar registro");
				}
			},
			error	: function() {
				$("#msg").show();
				$("#msg").html("Error actualizar empleado nuevamente");
			}
				
		});
		break;
		
	case "delete":
		$.ajax({
			type 	: "post",
			url	 	: "/employees/delete",
			data	: "employee_id=" + $("#employee_id").val(),

			success	: function(res) {
				if(res == 1) {
					$("#msg").removeClass("alert-danger").addClass("alert-success");
					$("#msg").show();
					$("#msg").html("Registro eliminado correctamente");
				} else {
					$("#msg").show();
					$("#msg").html("No se pudo eliminar registro");
				}
			},
			error	: function() {
				$("#msg").show();
				$("#msg").html("Error en elimininacion de empleados");
			}
				
		});
		break;
		
	default:
		$("#msg").show();
		$("#msg").html("Opcion incorrecta");
		break;
	}
}