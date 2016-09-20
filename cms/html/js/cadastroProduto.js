$(document).ready(function(){

    $('.imagem-container i').on('click', function(){
//        var container = "";
        var container = $(this).closest('.imagem-container');
        
        $('#input-foto').trigger('click');
        
        $('#input-foto').on('change', function(){
            var input = this.files[0];
            var reader = new FileReader();
                
            if(input){
             
                reader.readAsDataURL(input);
                    
            }else{
                
                console.log('Error - Input False');
                
            }
            
            reader.onloadend = function(){
                $('#' + $(container).attr('id') + ' i').remove();
//                $('#' + $(container).attr('id')).add('<img src="' + reader.result +'" alt="Produto 1">');
                $('#' + $(container).attr('id')).append('<img src="' + reader.result +'" alt="Produto 1">');
//                $('#' + $(container).attr('id') + ' img').attr('src', reader.result);
                $('#' + $(container).data('actions')).show();
                console.log('#' + $(container).data('actions'));
                container = " ";
             }; 
        });
    });
    
    var verificaCheckBox = function(checkBox, input){
        
        $(checkBox).on('click', function(){

            if($(this).prop('checked')){

                $(input).prop('disabled', true);

            }else{

                $(input).prop('disabled', false);

            }   
        });    
    }
    
    verificaCheckBox('#parcelasCheck','#parcelas');
    verificaCheckBox('#jurosCheck','#juros');  

//INICIALIZAÇÕES MATERIALIZE
    
//    CONTADOR DE CARATERES DESCRIÇÃO PRODUTO
//    $(document).ready(function() {
//    $('textarea#descricaoProduto').characterCounter();
//  });
});