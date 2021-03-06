
if(!window.File && window.FileReader){
    alert("API de Arquivos não é Compatível");
}

function getImageFile(container, inputFile,btEnviar, btExcluir, lbNameFile, alt){
    
    $(inputFile).trigger('click');
    
    $(inputFile).on('change', function(){
        
        var input = this.files[0];
        
        if(input.type == "image/jpeg" || input.type == "image/png"){
              var reader = new FileReader();
        
//            console.log('Nome - ' + input.name + ' Ultima Modificação - ' + input.lastModifiedDate + ' Tamanho - ' + input.size + ' Tipo - ' + input.type + ' Path ' + $(inputFile).val());
        
            if(input){
                reader.readAsDataURL(input);
            }else{
                console.error('Error: Input False');
            }

            reader.onloadend = function(){
                $(container).children('img').remove();
                $(container).append('<img src="' + reader.result +'" alt="' + alt + '">');
                $(btEnviar).removeClass('offset-s1 offset-m1 offset-l1');
                $(btEnviar + ' span').text('Editar');
                $(btExcluir).show();
            };
            
            $(lbNameFile).text(input.name);
            
        }else{
            $('.banner .label-error p').append(' ' + input.type);
            $('.banner .label-error').show();
        } 
    });
}

function deleteBanner(banner_container,button_delete,button_send,span_name_file){
    $(banner_container).children('img')
        .hide('slow', function(){
            $(this).remove();
    });
    $(button_delete).hide('slow');
    $(button_send).children('span').html('Enviar');
    $(button_send).addClass('offset-s1 offset-m1 offset-l1');
    $(span_name_file).html('Nenhum Arquivo Selecionado');
}