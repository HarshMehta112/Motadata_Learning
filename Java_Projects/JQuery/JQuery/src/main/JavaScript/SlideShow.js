$(function () {
        var galleryImage = $(".galary").find("img").first();

        var images = [
            "/home/harsh/Pictures/Screenshot from 2023-04-29 10-37-05.png",
            "/home/harsh/Pictures/Screenshot from 2023-04-29 20-23-54.png",
            "/home/harsh/Pictures/Screenshot from 2023-04-21 08-56-36.png"
        ];

        var i = 0;

        setInterval(function () {
            i = (i + 1) % images.length;
            galleryImage.fadeOut(function () {
                $(this).attr("src", images[i]);
                $(this).fadeIn();
            });
        }, 2000);

    }
);