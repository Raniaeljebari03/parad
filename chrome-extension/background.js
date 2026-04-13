chrome.runtime.onInstalled.addListener(() => {
  chrome.contextMenus.create({
    id: "translateText",
    title: "Translate to Darija",
    contexts: ["selection"]
  });
});

chrome.contextMenus.onClicked.addListener((info, tab) => {
  if (info.menuItemId === "translateText" && info.selectionText) {
    chrome.storage.local.set({ selectedText: info.selectionText });

    chrome.sidePanel.setOptions({
      tabId: tab.id,
      path: "side_panel.html",
      enabled: true
    });
  }
});