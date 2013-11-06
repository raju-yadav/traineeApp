$(function() {
	$("#timeSlot").timepicker({ampm: true});
    // Team Management
    $("#teamDataPanel").dataTable({
    	'bProcessing': true,
    	    "bJQueryUI": true,
    	    "bPaginate": true,    
    	    "bAutoWidth": false,
    	    "bFilter" : true,
    	    "bDestory" : true,
    	    "oLanguage": {
    	         "sLengthMenu": 'show <select style="width:150px">'+
    	           '<option value="5">5</option>'+
    	           '<option value="10">10</option>'+
    	           '<option value="15">15</option>'+
    	           '<option value="20">20</option>'+
    	           '<option value="-1">All</option>'+
    	           '</select> records'
    	       },
        "iDisplayLength": 5,
        "aLengthMenu": [[5, 10, 15, 20, -1], [5, 10, 15, 20, "All"]]
      } );
    $("#suc").hide(8000);
    //Training 
    $("#trFrom").datepicker({ dateFormat: 'dd/mm/yy', showOn: 'button', buttonImage: contextRoot + '/images/calendar1.jpg', buttonImageOnly: true, minDate: +0, maxDate: "7d"});
    $("#trEnd").datepicker({ dateFormat: 'dd/mm/yy', showOn: 'button', buttonImage: contextRoot + '/images/calendar1.jpg', buttonImageOnly: true, minDate: +0, maxDate: "1m 7d"});
   //FeedBack
    $("#dateofFeedback").datepicker({ dateFormat: 'dd/mm/yy', showOn: 'button', buttonImage: contextRoot + '/images/calendar1.jpg', buttonImageOnly: true, minDate: +0, maxDate: "7d"});
    $("#stdatepick").datepicker({ dateFormat: 'dd/mm/yy', showOn: 'button', buttonImage: contextRoot + '/images/calendar1.jpg', buttonImageOnly: true, minDate: +0, maxDate: "7d"});
    // On Change fuctions
    
    $("#trainingName").change(function() {
    	loadtraName("#traName1", this.value);
    	loadtrainingtype("#traType", this.value);
        loadfromDate("#fromDate", this.value);
        loadtoDate("#toDate", this.value);
        
    });
    
    $("#exselect").change(function()
    		{
    			
    		    if(this.value=="External")
    		    	{
    		    	 $("#venu").show();
    		    	}
    		    else{
    		    	$("#venu").hide();
    		    }
    		});
    		

});

function loadtrainingtype(targetPanel, trainingName) {
    $.ajax({
        url: contextRoot + '/corefiles/invitation/trainingType.htm',
        data: {trainingName: trainingName},
        type: 'POST',
        success : function(html) {
            $(targetPanel).html(html);
            
        }
    });
}


function loadfromDate(targetPanel, trainingName) {
	$.ajax({
		url: contextRoot + '/corefiles/invitation/fromDate.htm',
        data: {trainingName: trainingName},
        type: 'POST',
        success : function(html) {
            $(targetPanel).html(html);
        }
	});
}
function loadtoDate(targetPanel, trainingName) {
		$.ajax({
			url: contextRoot + '/corefiles/invitation/toDate.htm',
	        data: {trainingName: trainingName },
	        type: 'POST',
	        success : function(html) {
	            $(targetPanel).html(html);
	        }   
		});
	}
function loadtraName(targetPanel, trainingName) {
		$.ajax({
			url: contextRoot + '/corefiles/invitation/traName.htm',
	        data: {trainingName: trainingName },
	        type: 'POST',
	        success : function(html) {
	            $(targetPanel).html(html);
	        }   
		});
		
	}


/*function loadstdate(targetPanel, trainingName) {
	$.ajax({
		url: contextRoot + '/corefiles/modification/trainingstdate.htm',
        data: {trainingName: trainingName},
        type: 'POST',
        success : function(html) {
            $(targetPanel).html(html);
        }
	});
}*/
	