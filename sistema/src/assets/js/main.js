(function($) {
    "use strict";
    $(window).on('load', function() {
        $('.preloader').delay('500').fadeOut(2000);
    });

    function carousel() {
        var owlslider = jQuery("div.owl-carousel");
        if (owlslider.length > 0) {
            owlslider.each(function () {
                var $this = $(this),
                $items = ($this.data('items')) ? $this.data('items') : 1,
                $loop = ($this.attr('data-loop')) ? $this.data('loop') : true,
                $navdots = ($this.data('nav-dots')) ? $this.data('nav-dots') : false,
                $navarrow = ($this.data('nav-arrow')) ? $this.data('nav-arrow') : false,
                $autoplay = ($this.attr('data-autoplay')) ? $this.data('autoplay') : true,
                $autospeed = ($this.attr('data-autospeed')) ? $this.data('autospeed') : 5000,
                $smartspeed = ($this.attr('data-smartspeed')) ? $this.data('smartspeed') : 1000,
                $autohgt = ($this.data('autoheight')) ? $this.data('autoheight') : false,
                $space = ($this.attr('data-space')) ? $this.data('space') : 30,
                $animateOut = ($this.attr('data-animateOut')) ? $this.data('animateOut') : false;

                $(this).owlCarousel({
                    loop: $loop,
                    items: $items,
                    responsive: {
                        0: {
                        items: $this.data('xx-items') ? $this.data('xx-items') : 1
                        },
                        480: {
                        items: $this.data('xs-items') ? $this.data('xs-items') : 1
                        },
                        768: {
                        items: $this.data('sm-items') ? $this.data('sm-items') : 2
                        },
                        980: {
                        items: $this.data('md-items') ? $this.data('md-items') : 3
                        },
                        1200: {
                        items: $items
                        }
                    },
                    dots: $navdots,
                    autoplayTimeout: $autospeed,
                    smartSpeed: $smartspeed,
                    autoHeight: $autohgt,
                    margin: $space,
                    nav: $navarrow,
                    navText: ["<i class='fas fa-arrow-left'></i>", "<i class='fas fa-arrow-right'></i>"],
                    autoplay: $autoplay,
                    autoplayHoverPause: true
                });
            });
        }
    }

    $(document).ready(function() {
        carousel();


        $(document).on("click", ".menu-toggler", function() {
            $(this).toggleClass('active');
            $(".main-menu").slideToggle(200);
        });
        var dropdowmMenu = $('.main-menu .dropdown-menu-item, .menu-category .sub-menu');
        dropdowmMenu.parent('li').children('a').append(function() {
            return '<button class="sub-nav-toggler" type="button"><i class="la la-angle-down"></i></button>';
        });
        var dropMenuToggler = $('.main-menu .sub-nav-toggler, .menu-category .sub-nav-toggler');
        dropMenuToggler.on('click', function() {
            var Self = $(this);
            Self.parent().parent().children('.dropdown-menu-item, .sub-menu').fadeToggle();
            return false;
        });
        var isMenuOpen = false;
        $(window).on('resize', function() {
            if ($(window).width() > 991) {
                $('.main-menu').show();
                $('.dropdown-menu-item').show();
                $('.sub-menu').show();
            } else {
                if (isMenuOpen) {
                    $('.main-menu').show();
                    $('.dropdown-menu-item').show();
                    $('.sub-menu').show();
                } else {
                    $('.main-menu').hide();
                    $('.dropdown-menu-item').hide();
                    $('.sub-menu').hide();
                }
            }
        });
        var scrollButton = $('#scroll-top');
        var nav = document.querySelector('.header-menu-content');
        if (nav) {
            var topOfNav = nav.offsetTop;
        }
        $(window).on('scroll', function() {
            if ($(window).scrollTop() >= topOfNav) {
                document.body.style.paddingTop = nav.offsetHeight + 'px';
                document.body.classList.add('fixed-nav');
            } else {
                document.body.style.paddingTop = '0px';
                document.body.classList.remove('fixed-nav');
            }
            if ($(this).scrollTop() >= 300) {
                scrollButton.show();
            } else {
                scrollButton.hide();
            }
            var my_skill = '.skills .skill';
            if ($(my_skill).length !== 0) {
                spy_scroll(my_skill);
            }
        });
        $(document).on('click', '#scroll-top', function() {
            $('html, body').animate({
                scrollTop: 0
            }, 1000);
        });
        $(document).on('click', '.side-menu-open', function() {
            $('.user-nav-container').addClass('active');
        });
        $(document).on('click', '.dashboard-nav-trigger-btn', function() {
            $('.dashboard-nav-container').addClass('active');
        });
        $(document).on('click', '.humburger-menu .side-menu-close', function() {
            $('.side-nav-container, .user-nav-container, .dashboard-nav-container').removeClass('active');
        });
        $('.hero-slide').owlCarousel({
            items: 1,
            nav: true,
            dots: true,
            autoplay: false,
            loop: true,
            smartSpeed: 6000,
            animateOut: 'slideOutRight',
            animateIn: 'fadeIn',
            active: true,
            navText: ["<i class='la la-angle-left'></i>", "<i class='la la-angle-right'></i>"],
        });
        $('.course-carousel').owlCarousel({
            loop: true,
            items: 3,
            nav: true,
            dots: false,
            smartSpeed: 500,
            autoplay: false,
            margin: 30,
            navText: ["<i class='la la-angle-left'></i>", "<i class='la la-angle-right'></i>"],
            responsive: {
                320: {
                    items: 1,
                },
                992: {
                    items: 3,
                }
            }
        });
        $('.view-more-carousel').owlCarousel({
            loop: true,
            items: 2,
            nav: false,
            dots: true,
            smartSpeed: 500,
            autoplay: true,
            margin: 15,
            responsive: {
                320: {
                    items: 1,
                },
                768: {
                    items: 2,
                }
            }
        });
        $('.view-more-carousel-2').owlCarousel({
            loop: true,
            items: 3,
            nav: false,
            dots: true,
            smartSpeed: 500,
            autoplay: true,
            margin: 15,
            responsive: {
                320: {
                    items: 1,
                },
                768: {
                    items: 3,
                }
            }
        });
        $('.testimonial-carousel').owlCarousel({
            loop: true,
            items: 5,
            nav: false,
            dots: true,
            smartSpeed: 500,
            autoplay: false,
            margin: 30,
            autoHeight: true,
            responsive: {
                320: {
                    items: 1,
                },
                767: {
                    items: 2,
                },
                992: {
                    items: 3,
                },
                1025: {
                    items: 4,
                },
                1440: {
                    items: 5,
                }
            }
        });
        $('.testimonial-carousel-2').owlCarousel({
            loop: true,
            items: 2,
            nav: true,
            dots: false,
            smartSpeed: 500,
            autoplay: false,
            margin: 30,
            autoHeight: true,
            navText: ["<i class='la la-angle-left'></i>", "<i class='la la-angle-right'></i>"],
            responsive: {
                320: {
                    items: 1,
                },
                768: {
                    items: 2
                }
            }
        });
        $('.client-logo').owlCarousel({
            loop: true,
            items: 5,
            nav: false,
            dots: false,
            smartSpeed: 500,
            autoplay: false,
            responsive: {
                0: {
                    items: 2
                },
                481: {
                    items: 3
                },
                768: {
                    items: 4
                },
                992: {
                    items: 5
                }
            }
        });
        $('.blog-post-carousel').owlCarousel({
            loop: true,
            items: 3,
            nav: false,
            dots: true,
            smartSpeed: 500,
            autoplay: false,
            margin: 30,
            responsive: {
                320: {
                    items: 1,
                },
                992: {
                    items: 3,
                }
            }
        });
        $('[data-toggle="tooltip"]').tooltip();
        $('.faq-body > .faq-panel.is-active').children('.faq-content').show();
        $('.faq-body > .faq-panel').on('click', function() {
            $(this).siblings('.faq-panel').removeClass('is-active').children('.faq-content').slideUp(200);
            $(this).toggleClass('is-active').children('.faq-content').slideToggle(200);
        });
        $(document).on('click', '.portfolio-filter li', function() {
            var filterData = $(this).attr('data-filter');
            $('.portfolio-list').isotope({
                filter: filterData,
            });
            $('.portfolio-filter li').removeClass('active');
            $(this).addClass('active');
        });
        $('.portfolio-list').isotope({
            itemSelector: '.single-portfolio-item',
            percentPosition: true,
            masonry: {
                columnWidth: '.single-portfolio-item',
                horizontalOrder: true
            }
        });
        $('[data-fancybox="gallery"]').fancybox({
            buttons: ["zoom", "share", "slideShow", "fullScreen", "download", "thumbs", "close"],
        });
        $.fancybox.defaults.animationEffect = "zoom";
        $('[data-fancybox="video"]').fancybox({
            buttons: ["share", "fullScreen", "close"]
        });
        if ($("#map").length) {
            initMap('map', 40.717499, -74.044113, 'images/map-marker.png');
        }
        $(document).on('click', '.input-number-increment', function() {
            var $input = $(this).parents('.input-number-group').find('.input-number');
            var val = parseInt($input.val(), 10);
            $input.val(val + 1);
        });
        $(document).on('click', '.input-number-decrement', function() {
            var $input = $(this).parents('.input-number-group').find('.input-number');
            var val = parseInt($input.val(), 10);
            $input.val(val - 1);
        });
        $('.card-preview').tooltipster({
            contentCloning: true,
            interactive: true,
            side: 'right',
            delay: 100,
            animation: 'swing',
        });
        $('.filer_input').filer({
            limit: 10,
            maxSize: 100,
            showThumbs: true
        });
        if ($('.datepicker').length) {
            $('.datepicker').dateTimePicker({
                format: 'dd/MM/yyyy'
            });
        }
        if ($('.emoji-picker').length) {
            $(".emoji-picker").emojioneArea({
                pickerPosition: "top"
            });
        }
        if ($('.counter').length) {
            $('.counter').counterUp({
                delay: 10,
                time: 1000
            });
        }
        $('.course-list > .course-item-link').on('click', function() {
            $(this).addClass('active');
            $(this).siblings().removeClass('active');
            if ($(this).is('.active-resource')) {
                $('.lecture-viewer-text-wrap').addClass('active');
            } else if ($(this).not('.active-resource')) {
                $('.lecture-viewer-text-wrap').removeClass('active');
            }
        });
        $(document).on('click', '.sidebar-close', function() {
            $('.course-dashboard-sidebar-column, .course-dashboard-column, .sidebar-open').addClass('active');
        });
        $(document).on('click', '.sidebar-open', function() {
            $('.course-dashboard-sidebar-column, .course-dashboard-column, .sidebar-open').removeClass('active');
        });
        $(document).on('click', '.ask-new-question-btn', function() {
            $('.new-question-wrap, .question-overview-result-wrap').addClass('active');
        });
        $(document).on('click', '.question-meta-content, .question-replay-btn', function() {
            $('.replay-question-wrap, .question-overview-result-wrap').addClass('active');
        });
        $(document).on('click', '.back-to-question-btn', function() {
            $('.new-question-wrap, .question-overview-result-wrap, .replay-question-wrap').removeClass('active');
        });
        $(document).on('click', '.swapping-btn', function() {
            $(this).siblings('.bookmark-icon').toggleClass('active');
            var el = $(this);
            el.text() == el.data('text-swap') ? el.text(el.data('text-original')) : el.text(el.data('text-swap'));
        });
        $(document).on('click', '.search-form-btn', function() {
            $('.search-course-form').toggleClass('active');
        });
        $(document).on('click', '.search-close-icon', function() {
            $('.search-course-form').removeClass('active');
        });
        $(document).on('click', '.collection-link', function() {
            $(this).children('.collection-icon').toggleClass('active');
        });
        $('.sort-ordering-select').selectpicker({
            liveSearch: true,
            liveSearchPlaceholder: 'Search',
            liveSearchStyle: 'contains',
            size: 5
        });
        $('#teamModal').on('show.bs.modal', function(event) {
            var button = $(event.relatedTarget);
            var recipient = button.data('whatever');
            var modal = $(this);
            modal.find('.modal-title').text(recipient + '\'s Bio');
        });
    });

})(jQuery);
