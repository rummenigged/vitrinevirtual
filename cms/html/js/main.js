//$(document).ready(function(){

      $(document).ready(function() {
        $('select').material_select();
      
    
    //MOSTRAR MENU-LATERAL FIXO NO DESKTOP 
    if($(window).width() > 900){
        $('.side-menu').show();
        $('.side-menu').css({left : 0});
        $('.logo').show();
    }
    
    
    //MOSTRAR MENU-LATERAL NO CLICK DO BOTÃO TOGGLE
    var isOpen = false;
    $('#menu-sandwich').on('click', function(){
        
        if($(window).width() < 600 && isOpen == false){
            $('.side-menu').show();
            $('.side-menu').animate({left : 0}, 500);
            $('.content').animate({left : "50%"}, 500);
            $('#menu-sandwich i').text('close');
            
            isOpen = true;
        }else if($(window).width() < 900 && $(window).width() > 600 && isOpen == false){
            $('.side-menu').css({width : '30%'});
            $('.side-menu').show();
            $('.side-menu').animate({left : 0}, 500);
            $('.content').animate({left : "30%"}, 500);
            $('#menu-sandwich i').text('close');
            
            isOpen = true;
        }else if($(window).width() < 600 && isOpen == true){
            $('.side-menu').animate({left : "-50%"}, 500);
            $('.content').animate({left : 0},500,function(){
                $('.side-menu').hide()}
            );
            
            $('#menu-sandwich i').text('menu');
            isOpen = false;
        }else if($(window).width() < 900 && $(window).width() > 600 && isOpen == true){
            $('.side-menu').animate({left : "-30%"}, 500);
            $('.content').animate({left : 0},500,function(){
                $('.side-menu').hide()}
            );      
            $('#menu-sandwich i').text('menu');
            
            isOpen = false;
        }
    });
    
    $('#menu-close').on('hover', function(){
        
    });
    
    $('#menu-sandwich').on('hover', function(){
        
    });
    
    $('.drop-menu').on('click', function(){
        
    });
          
    });
//});
