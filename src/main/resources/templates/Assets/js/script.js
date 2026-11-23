const menuButton = document.querySelector('.menu-toggle');
const navigation = document.querySelector('.navigation');

menuButton?.addEventListener('click', () => {
    const isOpen = navigation.classList.toggle('open');
    menuButton.setAttribute('aria-expanded', String(isOpen));
    menuButton.setAttribute('aria-label', isOpen ? 'Fechar menu' : 'Abrir menu');
    menuButton.textContent = isOpen ? '×' : '☰';
});

navigation?.querySelectorAll('a').forEach((link) => {
    link.addEventListener('click', () => {
        navigation.classList.remove('open');
        menuButton?.setAttribute('aria-expanded', 'false');
        if (menuButton) {
            menuButton.setAttribute('aria-label', 'Abrir menu');
            menuButton.textContent = '☰';
        }
    });
});

const year = document.getElementById('year');
if (year) year.textContent = new Date().getFullYear();

const form = document.getElementById('formMaterial');
const feedback = document.getElementById('formFeedback');

form?.addEventListener('submit', async (event) => {
    event.preventDefault();
    feedback.textContent = 'Adicionando sua peça…';
    feedback.classList.remove('error');

    const button = form.querySelector('button[type="submit"]');
    button.disabled = true;

    try {
        const response = await fetch('/material/criar', {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify({
                nome: document.getElementById('nome').value.trim(),
                tipo: document.getElementById('tipo').value.trim(),
                quantidade: Number(document.getElementById('quantidade').value)
            })
        });

        if (!response.ok) throw new Error('Não foi possível adicionar a peça. Tente novamente.');

        form.reset();
        document.getElementById('quantidade').value = 1;
        feedback.textContent = 'Peça adicionada ao seu acervo. Que bom ter você por aqui!';
    } catch (error) {
        feedback.textContent = error.message || 'Não foi possível conectar ao acervo. Tente novamente.';
        feedback.classList.add('error');
    } finally {
        button.disabled = false;
    }
});
