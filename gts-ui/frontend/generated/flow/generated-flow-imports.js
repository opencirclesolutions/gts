import { injectGlobalCss } from 'Frontend/generated/jar-resources/theme-util.js';

import { css, unsafeCSS, registerStyles } from '@vaadin/vaadin-themable-mixin';
import $cssFromFile_0 from 'Frontend/generated/jar-resources/styles/grid.css?inline';
const $css_0 = typeof $cssFromFile_0  === 'string' ? unsafeCSS($cssFromFile_0) : $cssFromFile_0;
registerStyles('vaadin-selection-grid', $css_0, {moduleId: 'flow_css_mod_0'});
import $cssFromFile_1 from 'Frontend/generated/jar-resources/styles/enhanced-form-item.css?inline';
const $css_1 = typeof $cssFromFile_1  === 'string' ? unsafeCSS($cssFromFile_1) : $cssFromFile_1;
registerStyles('vaadin-form-item', $css_1, {moduleId: 'flow_css_mod_1'});
import $cssFromFile_2 from 'Frontend/themes/my-theme/vaadin-custom-field.css?inline';
const $css_2 = typeof $cssFromFile_2  === 'string' ? unsafeCSS($cssFromFile_2) : $cssFromFile_2;
registerStyles('vaadin-custom-field', $css_2, {moduleId: 'flow_css_mod_2'});
import $cssFromFile_3 from 'Frontend/themes/my-theme/vaadin-button.css?inline';
const $css_3 = typeof $cssFromFile_3  === 'string' ? unsafeCSS($cssFromFile_3) : $cssFromFile_3;
registerStyles('vaadin-button', $css_3, {moduleId: 'flow_css_mod_3'});
import $cssFromFile_4 from 'Frontend/themes/my-theme/vaadin-dialog.css?inline';
const $css_4 = typeof $cssFromFile_4  === 'string' ? unsafeCSS($cssFromFile_4) : $cssFromFile_4;
registerStyles('vaadin-dialog', $css_4, {moduleId: 'flow_css_mod_4'});
import $cssFromFile_5 from 'Frontend/themes/my-theme/vaadin-grid.css?inline';
const $css_5 = typeof $cssFromFile_5  === 'string' ? unsafeCSS($cssFromFile_5) : $cssFromFile_5;
registerStyles('vaadin-grid', $css_5, {moduleId: 'flow_css_mod_5'});
import $cssFromFile_6 from 'Frontend/themes/my-theme/vaadin-menu-bar.css?inline';
const $css_6 = typeof $cssFromFile_6  === 'string' ? unsafeCSS($cssFromFile_6) : $cssFromFile_6;
registerStyles('vaadin-menu-bar', $css_6, {moduleId: 'flow_css_mod_6'});
import 'Frontend/generated/jar-resources/flow-component-renderer.js';
import '@vaadin/polymer-legacy-adapter/style-modules.js';
import '@vaadin/combo-box/theme/lumo/vaadin-combo-box.js';
import 'Frontend/generated/jar-resources/comboBoxConnector.js';
import '@vaadin/radio-group/theme/lumo/vaadin-radio-group.js';
import '@vaadin/list-box/theme/lumo/vaadin-list-box.js';
import '@vaadin/radio-group/theme/lumo/vaadin-radio-button.js';
import '@vaadin/tooltip/theme/lumo/vaadin-tooltip.js';
import '@vaadin/tabs/theme/lumo/vaadin-tab.js';
import 'Frontend/generated/jar-resources/src/vcf-selection-grid.js';
import '@vaadin/grid/theme/lumo/vaadin-grid.js';
import 'Frontend/generated/jar-resources/src/selection-grid.js';
import '@vaadin/progress-bar/theme/lumo/vaadin-progress-bar.js';
import '@vaadin/button/theme/lumo/vaadin-button.js';
import 'Frontend/generated/jar-resources/buttonFunctions.js';
import '@vaadin/checkbox-group/theme/lumo/vaadin-checkbox-group.js';
import 'Frontend/generated/jar-resources/vaadin-big-decimal-field.js';
import '@vaadin/form-layout/theme/lumo/vaadin-form-layout.js';
import '@vaadin/vertical-layout/theme/lumo/vaadin-vertical-layout.js';
import '@vaadin/grid/theme/lumo/vaadin-grid-column-group.js';
import '@vaadin/icon/theme/lumo/vaadin-icon.js';
import '@vaadin/upload/theme/lumo/vaadin-upload.js';
import '@vaadin/grid/theme/lumo/vaadin-grid-column.js';
import '@vaadin/grid/theme/lumo/vaadin-grid-sorter.js';
import '@vaadin/checkbox/theme/lumo/vaadin-checkbox.js';
import 'Frontend/generated/jar-resources/gridConnector.ts';
import '@vaadin/custom-field/theme/lumo/vaadin-custom-field.js';
import '@vaadin/time-picker/theme/lumo/vaadin-time-picker.js';
import 'Frontend/generated/jar-resources/vaadin-time-picker/timepickerConnector.js';
import 'Frontend/generated/jar-resources/vaadin-grid-flow-selection-column.js';
import '@vaadin/item/theme/lumo/vaadin-item.js';
import 'Frontend/generated/jar-resources/menubarConnector.js';
import '@vaadin/menu-bar/theme/lumo/vaadin-menu-bar.js';
import '@vaadin/dialog/theme/lumo/vaadin-dialog.js';
import '@vaadin/horizontal-layout/theme/lumo/vaadin-horizontal-layout.js';
import '@vaadin/integer-field/theme/lumo/vaadin-integer-field.js';
import '@vaadin/password-field/theme/lumo/vaadin-password-field.js';
import '@vaadin/email-field/theme/lumo/vaadin-email-field.js';
import '@vaadin/context-menu/theme/lumo/vaadin-context-menu.js';
import 'Frontend/generated/jar-resources/contextMenuConnector.js';
import 'Frontend/generated/jar-resources/contextMenuTargetConnector.js';
import '@vaadin/form-layout/theme/lumo/vaadin-form-item.js';
import '@vaadin/multi-select-combo-box/theme/lumo/vaadin-multi-select-combo-box.js';
import '@vaadin/number-field/theme/lumo/vaadin-number-field.js';
import '@vaadin/text-field/theme/lumo/vaadin-text-field.js';
import '@vaadin/icons/vaadin-iconset.js';
import '@vaadin/date-picker/theme/lumo/vaadin-date-picker.js';
import 'Frontend/generated/jar-resources/datepickerConnector.js';
import '@vaadin/text-area/theme/lumo/vaadin-text-area.js';
import '@vaadin/date-time-picker/theme/lumo/vaadin-date-time-picker.js';
import '@vaadin/tabs/theme/lumo/vaadin-tabs.js';
import 'Frontend/generated/jar-resources/lit-renderer.ts';
import '@vaadin/notification/theme/lumo/vaadin-notification.js';
import '@vaadin/common-frontend/ConnectionIndicator.js';
import '@vaadin/vaadin-lumo-styles/color-global.js';
import '@vaadin/vaadin-lumo-styles/typography-global.js';
import '@vaadin/vaadin-lumo-styles/sizing.js';
import '@vaadin/vaadin-lumo-styles/spacing.js';
import '@vaadin/vaadin-lumo-styles/style.js';
import '@vaadin/vaadin-lumo-styles/vaadin-iconset.js';

const loadOnDemand = (key) => {
  const pending = [];
  if (key === '0c7f39a7794c8c95f7d675e256266374301cbd387451ffb39b63a2902d90d1cf') {
    pending.push(import('./chunks/chunk-4430b2684b5d3b0c72bb794d9693a327f52027f6cb3b1beda9eefc183f6c2dba.js'));
  }
  if (key === 'a4fd6ae510c7a306337d9cb7d134d1b2e0c259b9d052312f76e9fb82425a26eb') {
    pending.push(import('./chunks/chunk-4430b2684b5d3b0c72bb794d9693a327f52027f6cb3b1beda9eefc183f6c2dba.js'));
  }
  if (key === '764369613e9f3a419e285cc58f50c47d8c524d4b8407af01ce47d04359ba2684') {
    pending.push(import('./chunks/chunk-4430b2684b5d3b0c72bb794d9693a327f52027f6cb3b1beda9eefc183f6c2dba.js'));
  }
  if (key === '53b04b43e22da91135dc9db15d8a21adb790fd1b8a94177ba1e16793465fa4ba') {
    pending.push(import('./chunks/chunk-3697e0c9c6a8155f9cbab9cf6ac5b1e0ab082b5c9f1c48cdcb7a74e600c40bcc.js'));
  }
  if (key === '5a45b218e44710635b0afd584b9b4cfc2da6576aaf29e8e415d165f689eed944') {
    pending.push(import('./chunks/chunk-3697e0c9c6a8155f9cbab9cf6ac5b1e0ab082b5c9f1c48cdcb7a74e600c40bcc.js'));
  }
  if (key === 'bcafe2c268cd2b8c6a9f4352ca8c6724e270d2ca89d712b39248199d36cdb3ea') {
    pending.push(import('./chunks/chunk-4430b2684b5d3b0c72bb794d9693a327f52027f6cb3b1beda9eefc183f6c2dba.js'));
  }
  return Promise.all(pending);
}

window.Vaadin = window.Vaadin || {};
window.Vaadin.Flow = window.Vaadin.Flow || {};
window.Vaadin.Flow.loadOnDemand = loadOnDemand;
window.Vaadin.Flow.resetFocus = () => {
 let ae=document.activeElement;
 while(ae&&ae.shadowRoot) ae = ae.shadowRoot.activeElement;
 return !ae || ae.blur() || ae.focus() || true;
}