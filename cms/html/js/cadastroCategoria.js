$(document).ready(function(){

    $('#send-image').on('click', function(){
        getImageFile('#banner-container','#input-banner','#send-image', '#excluir-banner', '#file-url', 'Banner Categoria');   
    });
    
    $('#excluir-banner').on('click', function(){
        $('#banner-container img').hide();
        $(this).hide();
        $('#send-image span').html('Enviar');
        $('#send-image').addClass('offset-s1 offset-m1 offset-l1');
        $('#file-url').html('Nenhum Arquivo Selecionado');
    });
});