document.addEventListener('DOMContentLoaded', () => {
    const fills = document.querySelectorAll('.rating-fill');

    const ratingColors = [
        getComputedStyle(document.documentElement).getPropertyValue('--consumr-rating-one').trim(),
        getComputedStyle(document.documentElement).getPropertyValue('--consumr-rating-two').trim(),
        getComputedStyle(document.documentElement).getPropertyValue('--consumr-rating-three').trim(),
        getComputedStyle(document.documentElement).getPropertyValue('--consumr-rating-four').trim(),
        getComputedStyle(document.documentElement).getPropertyValue('--consumr-rating-five').trim()
    ];

    function hexToRgb(hex) {
        hex = hex.replace('#','');
        let bigint = parseInt(hex, 16);
        let r = (bigint >> 16) & 255;
        let g = (bigint >> 8) & 255;
        let b = bigint & 255;
        return [r,g,b];
    }

    function interpolateColor(c1, c2, factor) {
        const [r1,g1,b1] = hexToRgb(c1);
        const [r2,g2,b2] = hexToRgb(c2);
        const r = Math.round(r1 + (r2 - r1) * factor);
        const g = Math.round(g1 + (g2 - g1) * factor);
        const b = Math.round(b1 + (b2 - b1) * factor);
        return `rgb(${r},${g},${b})`;
    }

    fills.forEach(fill => {
        const value = parseFloat(fill.getAttribute('value'));
        fill.style.width = `${(value / 5) * 100}%`;

        let lowerIndex = Math.floor(value) - 1;
        let upperIndex = Math.min(lowerIndex + 1, 4);
        let factor = value - Math.floor(value);

        fill.style.backgroundColor = interpolateColor(ratingColors[lowerIndex], ratingColors[upperIndex], factor);
    });

});