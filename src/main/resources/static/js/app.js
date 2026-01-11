// Small startup script to add a class to the document after DOM content loads.
// This allows CSS animations to be defined but only run after page has mounted.
document.addEventListener('DOMContentLoaded', function () {
    // slight delay for nicer stagger
    window.setTimeout(function(){ document.documentElement.classList.add('loaded'); }, 80);
});
