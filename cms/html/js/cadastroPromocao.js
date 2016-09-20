$(document).ready(function(){
    
    window.URL = window.URL || window.webkitURL;
    
    if(window.File && window.FileReader){}else{
        alert("API de Arquivos não é Compatível");
    }
        
    $('#input-banner').on('change', function(){
        var input = this.files[0];
        
        if(input.type == "image/jpeg" || input.type == "image/png"){

            var foto = $('#foto-banner');
            var reader = new FileReader();

    console.log('Nome - ' + input.name + ' Ultima Modificação - ' + input.lastModifiedDate + ' Tamanho - ' + input.size + ' Tipo - ' + input.type + ' Path ' + $('#input-banner').val());

            if(input){
                reader.readAsDataURL(input);
            }else{
                console.log('Erro - input False');
            }

            reader.onloadend = function(){            
                $(foto).attr('src', reader.result);
                $('#foto-banner').show();
                $('#up-banner').removeClass('offset-s1 offset-m1 offset-l1');
                $('#up-banner label').html('Editar');
                $('#excluir-banner').show();
                
            };

            $('#file-url').text(input.name);            
        }else{
            $('.label-error').append(input.type);
            $('.label-error').show();
        }
    });
    
    $('#excluir-banner').on('click', function(){
        $('#foto-banner').hide();
        $(this).hide();
        $('#up-banner label').html('Enviar');
        $('#up-banner').addClass('offset-s1 offset-m1 offset-l1');
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
     
//    INICIALIZAÇÕES MATERIALIZE
    
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