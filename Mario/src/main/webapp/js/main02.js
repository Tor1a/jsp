$.ajax({
	url:"MarioJsonList.do",
	dataType:"json",
	success:function(data){
		console.log(data);
		
		$("#main").append(`<ul class="list swiper-wrapper" id="marioList"></ul>`);
		$.each(data.marioList,function(i,item){
			$("#main .list").append(`
				<li class="swiper-slide">
					<div class="item">
						<div class="img">
							<img src="upload_mario/${item.marioRealImg }" alt="">
						</div>
						<div class="infoBox" style="background-color:${item.bg}">
							<h2>${item.title }</h2>
							<p>${item.contents }</p>
							<a href="${item.link }" target="_blank">more</a>
						</div>
					</div>
				</li>
			`);
		});
		const marioSlider = new Swiper("#main", {
			slidesPerView: "auto",
			centeredSlides: true,
			loop: true,
			spaceBetween: 30,
			mousewheel: true,
			effect: "coverflow",
			coverflowEffect: {
				rotate: 0,
				slideShadows: false,
				depth: 800
			},
		});
	}
});