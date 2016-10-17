$(document).ready(function () {

    var loadPhoto = function (container, input) {
        var input = input;
        
        $(input).trigger('click');
        
        $(input).on('change', function () {
            
            var file = this.files[0];
            var reader = new FileReader();
            
            if (file) {
                reader.readAsDataURL(file);
            }
            else {
                console.log('Error - Empty Input');
            }
            reader.onloadend = function () {
                $('#' + $(container).attr('id') + ' i').hide();
                $('#' + $(container).attr('id')).children('img').remove();
                $('#' + $(container).attr('id')).append('<img src="' + reader.result + '" alt="Produto 1">');
                $('#' + $(container).attr('id')).closest('.row').next('.row').children('.acoes').show();
                container = " ";
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
});