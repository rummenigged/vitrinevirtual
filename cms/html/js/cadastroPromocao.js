$(document).ready(function(){
    
    window.URL = window.URL || window.webkitURL;
      
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
    
    //Range para escolher intervalo de dias da duração da promoção
//       
//    $('#inicioPromo').on('input', function(){
//        $('#inicioDia').text(this.value);
//    });
//    
//    $('#fimPromo').on('input', function(){
//        $('#fimDia').text(this.value);
//    });
         
//    DATEPICKER
    $('#datepicker-inicio').on('change', function(){
        console.log($('#datepicker-inicio'));
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