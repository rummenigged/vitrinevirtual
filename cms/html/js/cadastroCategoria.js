$(document).ready(function(){

    $('#send-image').on('click', function(){
        getImageFile('#banner-container','#input-banner','#send-image', '#excluir-banner', '#file-url', 'Banner Categoria');   
    });
    
    $('#excluir-banner').on('click', function(){        
        deleteBanner('#banner-container',this,'#send-image','#file-url');
    });
    
    $('.label-error > i').on('click', function(){
        $(this).parent().hide();
    });
});