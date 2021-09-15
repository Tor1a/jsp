$.ajax({
			url : "ClockList.do",
			dataType : "json",
			success : function(data) {
				//console.log(data);
				$("#main").append(`<ul class="list"></ul>`);
				$.each(data.items,function(i,item){
					//console.log(${item.realClockImg});
					$("#main .list").append(`
							<li>
								<a href="">
									<div class="front">
										<div class="img">
											<img src="upload/${item.realClockImg}" alt="">
										</div>
									</div>
									<div class="back">
										<div class="info">
											<p class="category">${item.category}</p>
											<p class="title">${item.title}</p>
											<p class="depth">${item.depth}</p>
											<p class="price">${item.price}</p>
										</div>
									</div>
								</a>
							</li>		
								
					`)
				});
				//반복문 끝....
				gsap.from("#main .list li",{
					duration:1,
					scale:0,
					ease:"power4",
					stagger:0.1
				});
				$("#main .list li").on("click",function(){
					if(!$(this).hasClass("on")) {
						$(this).addClass("on");
						gsap.to($(this).find("a"),{
							duration:1.5,
							ease:"back.inOut",
							rotationX:180
						})
					} else {
						$(this).removeClass("on");
						gsap.to($(this).find("a"),{
							duration:1.5,
							ease:"back.inOut",
							rotationX:0
						})
					}
					return false;
				});
			}
		})