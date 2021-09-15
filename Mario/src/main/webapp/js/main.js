
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
