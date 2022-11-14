let replyService = (
	function(){
		function insertReplyVO(reply, callback, error){
			$.ajax({
				type : "post",
				url : "/replies/insert",
				data : JSON.stringify(reply),
				contentType : "application/json; charset=utf-8",
				success : function(result, status, xhr){
					if(callback){
						callback(result);
					}
				},
				error : function(xhr, status, er){
					if(error){
						error(er);
					}
				}
			});
		}

 function listReplyVO(param,callback,error){
      var bno = param.bno;
      var page = param.page || 1;

      $.getJSON(
        "/replies/pages/" + bno + "/" + page + ".json",
        function(data){
          if(callback){
            //callback(data);  페이징 없이 처리할떄
            callback(data.replyCnt,data.list);  //페이징 있을때
          }
        }).fail(
          function(xhr,status,err){
            if(error){
              error();
            }
        });

    }


		function deleteReplyVO(rno, callback, error){
			$.ajax({
				type : "delete",
				url : "/replies/"+rno,
				success : function(result, status, xhr){
					if(callback){
						callback(result);
					}
				},
				error : function(xhr, status, er){
					if(error){
						error(er);
					}
				}
			});
		}

		function updateReplyVO(reply, callback, error){
			$.ajax({
				type : "put",
				url : "/replies/" + reply.rno,
				data : JSON.stringify(reply),
				contentType : "application/json; charset=utf-8",
				success : function(result, status, xhr){
					if(callback){
						callback(result);
					}
				},
				error : function(xhr, status, er){
					if(error){
						error(er);
					}
				}
			});
		}

		function selectReplyVO(rno, callback, error){
			$.get("/replies/"+rno+".json", function(result){
				if(callback){
					callback(result);
				}
			}).fail(function(xhr, status, err){
				if(error){
					error();
				}
			});
		}
		
		function displayTime(timeValue) {

			var today = new Date();
	
			var gap = today.getTime() - timeValue;
	
			var dateObj = new Date(timeValue);
			var str = "";
	
			if (gap < (1000 * 60 * 60 * 24)) {
	
				var hh = dateObj.getHours();
				var mi = dateObj.getMinutes();
				var ss = dateObj.getSeconds();
	
				return [ (hh > 9 ? '' : '0') + hh, ':', (mi > 9 ? '' : '0') + mi,
						':', (ss > 9 ? '' : '0') + ss ].join('');
	
			} else {
				var yy = dateObj.getFullYear();
				var mm = dateObj.getMonth() + 1; // getMonth() is zero-based
				var dd = dateObj.getDate();
	
				return [ yy, '/', (mm > 9 ? '' : '0') + mm, '/',
						(dd > 9 ? '' : '0') + dd ].join('');
			}
		}
		
		return {
			insertReplyVO : insertReplyVO,
			listReplyVO : listReplyVO,
			deleteReplyVO : deleteReplyVO,
			updateReplyVO : updateReplyVO,
			selectReplyVO : selectReplyVO,
			displayTime : displayTime
		};
	}
)();