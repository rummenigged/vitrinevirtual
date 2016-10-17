$(document).ready(function () {
    //    var loadPhoto = function(container){
    //        $('#input-foto').trigger('click');
    //        
    //        $('#input-foto').on('change', function(){
    //            var input = this.files[0];
    //            var reader = new FileReader();
    //                
    //            if(input){
    //             
    //                reader.readAsDataURL(input);
    //                    
    //            }else{
    //                
    //                console.log('Error - Input False');
    //                
    //            }
    //            
    //            reader.onloadend = function(){
    //                $('#' + $(container).attr('id') + ' i').hide();
    //                $('#' + $(container).attr('id')).children('img').remove();
    //                $('#' + $(container).attr('id')).append('<img src="' + reader.result +'" alt="Produto 1">');
    //                $('#' + $(container).attr('id')).closest('.row').next('.row').children('.acoes').show();
    //                
    //                container = " ";//LIMPAR VARIAVEL CONTAINER PARA TRAZER APENAS UMA IMAGEM
    //             }; 
    //        });
    //    };
    
    var loadPhoto = function (container, input) {
        var input = input;
        console.log("Passo 1");
        $(input).trigger('click');
        console.log("Passo 2");
        $(input).on('change', function () {
            console.log("Passo 3");
            var file = this.files[0];
            var reader = new FileReader();
            console.log("Passo 4");
            if (file) {
                reader.readAsDataURL(file);
                console.log("Passo 5");
            }
            else {
                console.log('Error - Empty Input');
            }
            reader.onloadend = function () {
                console.log("Passo 6");
                $('#' + $(container).attr('id') + ' i').hide();
                $('#' + $(container).attr('id')).children('img').remove();
                $('#' + $(container).attr('id')).append('<img src="' + reader.result + '" alt="Produto 1">');
                $('#' + $(container).attr('id')).closest('.row').next('.row').children('.acoes').show();
                container = " ";
                console.log("Passo 7");
            };
        });
    };

    $('.foto-container i').on('click', function () {
        loadPhoto($(this).closest('.foto-container'), $(this).next());
    });

    $('.edit').on('click', function () {
        var container = $(this).parent('.acoes').parent('.row').closest('.imagem-container').children('.row').children('.foto-container');
        var input = $(this).parent('.acoes').parent('.row').closest('.imagem-container').children('.row').children('.foto-container').children('.file-input');
        loadPhoto(container, input);
    });

    $('.delete').on('click', function () {
        $(this).parent('.acoes').parent('.row').closest('.imagem-container').children('.row').children('.foto-container').children('img').remove();
        $(this).parent('.acoes').parent('.row').closest('.imagem-container').children('.row').children('.foto-container').children('i').show();
        $(this).parent('.acoes').hide();
    });
    
    var verificaCheckBox = function (checkBox, input) {
        $(checkBox).on('click', function () {
            if ($(this).prop('checked')) {
                $(input).prop('disabled', true);
            }
            else {
                $(input).prop('disabled', false);
            }
        });
    };

    verificaCheckBox('#parcelasCheck', '#parcelas');
    verificaCheckBox('#jurosCheck', '#juros');

    //INICIALIZAÇÕES MATERIALIZE
    //    CONTADOR DE CARATERES DESCRIÇÃO PRODUTO
    //    $(document).ready(function() {
    //    $('textarea#descricaoProduto').characterCounter();
    //  });
});