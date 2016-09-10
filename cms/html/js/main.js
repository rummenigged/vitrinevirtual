$(document).ready(function(){

      $(document).ready(function() {
        $('select').material_select();
      });
    
    if(screen.width > 900){
        $('.side-menu').show();
        $('.side-menu').css({left : 0});
        
        $('.logo').show();
    }
    $('#menu-sandwich').on('click', function(){
        
        $('.side-menu').show();
        $('.side-menu').animate({left : 0}, 500);
        $('.content').animate({left : "50%"}, 500);
        
    });
    
    $('#menu-close').on('click', function(){
        
        $('.side-menu').animate({left : "-50%"}, 500);
        $('.content').animate({left : 0},500,function(){
            $('.side-menu').hide()}
        );
        
    });
    
    $('#menu-close').on('hover', function(){
        
    });
    
    $('#menu-sandwich').on('hover', function(){
        
    });
    
    $('.drop-menu').on('click', function(){
        
    });
});
