const reviewStep = {
    steps: [
        {
            title: "Kims Ostepops",
            intro: "Produktanmeldelse",
            subtitle: "Din personlige vurdering af produktet",
            question: "Hvad synes du om smagen?",
            range: { min: 1.0, max: 5.0, step: 0.1, default: 3.0 },
            commentPlaceholder: "Skriv kommentar her..."
        },
        {
            title: "Kims Ostepops",
            intro: "Produktanmeldelse",
            subtitle: "Din personlige vurdering af produktet",
            question: "Hvad synes du om prisen?",
            range: { min: 1.0, max: 5.0, step: 0.1, default: 3.0 },
            commentPlaceholder: "Skriv kommentar her..."
        },
        {
            title: "Kims Ostepops",
            intro: "Produktanmeldelse",
            subtitle: "Din personlige vurdering af produktet",
            question: "Er emballagen god og intuitiv?",
            range: { min: 1.0, max: 5.0, step: 0.1, default: 3.0 },
            commentPlaceholder: "Skriv kommentar her..."
        },
        {
            title: "Kims Ostepops",
            intro: "Produktanmeldelse",
            subtitle: "Din personlige vurdering af produktet",
            question: "Ville du købe produktet igen?",
            range: { min: 1.0, max: 5.0, step: 0.1, default: 3.0 },
            commentPlaceholder: "Skriv kommentar her..."
        },
        {
            title: "Kims Ostepops",
            intro: "Produktanmeldelse",
            subtitle: "Din personlige vurdering af produktet",
            question: "",
            range: null,
            commentPlaceholder: "Skriv kommentar her..."
        }
    ],
    currentStep: 0
};

const btnPrev = document.querySelector('.btn-prev');
const btnNext = document.querySelector('.btn-next');
const stepElement = document.querySelector('.step');

function saveStepData() {
    const slider = stepElement.querySelector('.range-slider');
    const comment = stepElement.querySelector('.comment-input').value;
    let val = null;

    if (slider) {
        val = parseFloat(slider.value).toFixed(1);
    }

    let storedData = JSON.parse(localStorage.getItem('reviewData')) || [];
    storedData[reviewStep.currentStep] = {
        step: reviewStep.currentStep,
        value: val,
        comment: comment
    };
    localStorage.setItem('reviewData', JSON.stringify(storedData));
}

function loadStepData() {
    const storedData = JSON.parse(localStorage.getItem('reviewData')) || [];
    const stepData = storedData[reviewStep.currentStep];
    const slider = stepElement.querySelector('.range-slider');
    const comment = stepElement.querySelector('.comment-input');

    if (stepData) {
        if (slider && stepData.value !== null) slider.value = stepData.value;
        comment.value = stepData.comment || '';
    } else {
        if (slider) slider.value = reviewStep.steps[reviewStep.currentStep].range?.default || 3.0;
        comment.value = '';
    }
}

function updateSliderLabel(slider, display) {
    const val = parseFloat(slider.value).toFixed(1);
    let label = '';

    if (val == 1.0) label = 'Ekstrem dårlig';
    else if (val == 5.0) label = 'Perfekt';
    else if (val > 1.0 && val <= 2.0) label = 'Dårlig';
    else if (val > 2.0 && val <= 3.0) label = 'Middel';
    else if (val > 3.0 && val <= 4.0) label = 'God';
    else if (val > 4.0 && val < 5.0) label = 'Fremragende';

    display.textContent = `${val} — ${label}`;
}

function updateStep() {
    const data = reviewStep.steps[reviewStep.currentStep];

    stepElement.querySelector('.review-intro').textContent = data.intro;
    stepElement.querySelector('.review-title').textContent = data.title;
    stepElement.querySelector('.review-subtitle').textContent = data.subtitle;
    stepElement.querySelector('.step-question').textContent = data.question || '';

    const slider = stepElement.querySelector('.range-slider');
    const valueDisplay = stepElement.querySelector('.range-value');
    const commentInput = stepElement.querySelector('.comment-input');
    const commentLabel = stepElement.querySelector('.step-comment p');
    const dividers = stepElement.querySelectorAll('.step-divider');

    if (data.range) {
        slider.style.display = 'block';
        valueDisplay.style.display = 'block';
        slider.min = data.range.min;
        slider.max = data.range.max;
        slider.step = data.range.step;
    } else {
        slider.style.display = 'none';
        valueDisplay.style.display = 'none';
    }

    if (reviewStep.currentStep === reviewStep.steps.length - 1) {
        commentLabel.textContent = 'Din kommentar (Minimum 50 ord)';
    } else {
        commentLabel.textContent = 'Valgfri kommentar';
    }

    if (reviewStep.currentStep === reviewStep.steps.length - 1) {
        if (dividers[0]) dividers[0].style.display = 'none';
    } else {
        if (dividers[0]) dividers[0].style.display = 'block';
    }

    commentInput.placeholder = data.commentPlaceholder || '';
    loadStepData();

    if (slider) {
        slider.oninput = () => {
            updateSliderLabel(slider, valueDisplay);
            updateSliderColor(slider);
        };
        slider.oninput();
    }

    btnNext.textContent = reviewStep.currentStep === reviewStep.steps.length - 1 ? 'Send anmeldelse' : 'Næste';
}


btnPrev.addEventListener('click', () => {
    if (reviewStep.currentStep === 0) {
        window.location.href = 'http://localhost:7000';
    } else {
        saveStepData();
        reviewStep.currentStep--;
        updateStep();
    }
});

btnNext.addEventListener('click', () => {
    saveStepData();
    if (reviewStep.currentStep === reviewStep.steps.length - 1) {
        const allData = JSON.parse(localStorage.getItem('reviewData'));
        console.log('Send disse data til backend:', allData);
        alert('Anmeldelse sendt!');
        localStorage.removeItem('reviewData');
    } else {
        reviewStep.currentStep++;
        updateStep();
    }
});

function getColorFromValue(value, min, max) {
    const percent = (value - min) / (max - min);
    let r, g, b;

    if (percent <= 0.5) {
        r = 255;
        g = Math.round(510 * percent);
        b = 0;
    } else {
        r = Math.round(510 * (1 - percent));
        g = 255;
        b = 0;
    }

    return `rgb(${r}, ${g}, ${b})`;
}

function updateSliderColor(slider) {
    const min = parseFloat(slider.min);
    const max = parseFloat(slider.max);
    const val = parseFloat(slider.value);

    const percent = ((val - min) / (max - min)) * 100;
    const color = getColorFromValue(val, min, max);

    slider.style.background = `
        linear-gradient(
            to right,
            ${color} 0%,
            ${color} ${percent}%,
            rgba(255,255,255,0.2) ${percent}%,
            rgba(255,255,255,0.2) 100%
        )
    `;

    slider.style.setProperty('--thumb-color', color);
}

updateStep();