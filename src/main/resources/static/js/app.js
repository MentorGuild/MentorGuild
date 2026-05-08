// Small startup script to add a class to the document after DOM content loads.
// This allows CSS animations to be defined but only run after page has mounted.
document.addEventListener('DOMContentLoaded', async () => {

    // Animation logic with slight delay for nicer stagger
   setTimeout(() => {
        document.documentElement.classList.add('loaded');
         }, 80);

   //Find lessons container
   const grid = document.getElementById('lessons-grid');

       // Find lesson form
       const form = document.getElementById('lesson-form');

    // Load and display lessons
       async function loadLessons() {


   // If lessons grid doesn't exist, stop
   if (!grid){
    return;
   }

   try {

   //Call backend API
    const response = await fetch('/api/lessons');

    //Check for failed response
    if(!response.ok){
        throw new Error('Failed to fetch lessons');

   }

   //Convert JSON response into JavaScript objects
   const lessons = await response.json();

   //Clear placeholder content
   grid.innerHTML = '';

   //Create lesson cards dynamically
   lessons.forEach(lesson => {
    const card = document.createElement('article');
    card.className = 'lesson-card';
    card.innerHTML = '
        <div>
            <h3>${lesson.title}</h3>
            <p>${lesson.topic}</p>
        </div>
            ';
         grid.appendChild(card);
   });
   } catch (error) {
    console.error(error);
    grid.innerHTML = '
        <p>Failed to load lessons.</p>
    ';
    }

   })

});
