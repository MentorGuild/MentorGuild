// Small startup script to add a class to the document after DOM content loads.
// This allows CSS animations to be defined but only run after page has mounted.

document.addEventListener('DOMContentLoaded', async () => {

    // Animation logic with slight delay for nicer stagger
    setTimeout(() => {
        document.documentElement.classList.add('loaded');
    }, 80);

    // Find lessons container
    const grid = document.getElementById('lessons-grid');

    // Find lesson form
    const form = document.getElementById('lesson-form');

    // Load and display lessons
    async function loadLessons() {

        // If lessons grid doesn't exist, stop
        if (!grid) {
            return;
        }

        try {

            // Call backend API
            const response = await fetch('/api/lessons');

            // Handle failed response
            if (!response.ok) {
                throw new Error('Failed to fetch lessons');
            }

            // Convert JSON response into JavaScript objects
            const lessons = await response.json();

            // Clear current grid
            grid.innerHTML = '';

            // Create lesson cards dynamically
            lessons.forEach(lesson => {

                const card = document.createElement('article');

                card.className = 'lesson-card';

                card.innerHTML = `
                    <div>
                        <h3>${lesson.title}</h3>
                        <p>${lesson.topic}</p>
                    </div>
                `;

                // Add card to grid
                grid.appendChild(card);
            });

        } catch (error) {

            console.error(error);

            grid.innerHTML = `
                <p>Failed to load lessons.</p>
            `;
        }
    }

    // Load lessons immediately when page loads
    await loadLessons();

    // Handle lesson creation form
    if (form) {

        form.addEventListener('submit', async (event) => {

            // Prevent page refresh
            event.preventDefault();

            // Build lesson object from form inputs
            const lesson = {

                mentorId: crypto.randomUUID(),

                title: document.getElementById('title').value,

                topic: document.getElementById('topic').value,

                content: document.getElementById('content').value,

                tags: document
                    .getElementById('tags')
                    .value
                    .split(',')
                    .map(tag => tag.trim())
            };

            try {

                // Send POST request to backend
                const response = await fetch('/api/lessons', {

                    method: 'POST',

                    headers: {
                        'Content-Type': 'application/json'
                    },

                    body: JSON.stringify(lesson)
                });

                // Handle failed creation
                if (!response.ok) {
                    throw new Error('Failed to create lesson');
                }

                // Clear form after successful creation
                form.reset();

                // Reload lessons dynamically
                await loadLessons();

            } catch (error) {

                console.error(error);

                alert('Failed to create lesson');
            }
        });
    }
});