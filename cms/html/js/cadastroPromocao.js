$(document).ready(function(){
    
    window.URL = window.URL || window.webkitURL;
      
   $('#send-image').on('click', function(){
        getImageFile('#banner-container','#input-banner','#send-image', '#excluir-banner', '#file-url', 'Banner Categoria');   
    });
    
    $('#excluir-banner').on('click', function(){        
        deleteBanner('#banner-container',this,'#send-image','#file-url');
    });
    
    $('#datepicker-inicio').on('change', function(){
        $('#datepicker-fim').attr('disabled', false);
    });
    
    $('.label-error > i').on('click', function(){
        $(this).parent().hide();
    });
    
    $('.datepicker').pickadate({
    selectMonths: true, // Creates a dropdown to control month
    selectYears: 15 // Creates a dropdown of 15 years to control year
    });
     
});